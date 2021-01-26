﻿using BooksProiektua.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web.Mvc;

namespace BooksProiektua.Controllers
{
    public class LoginController : Controller
    {


        public ActionResult LoginForm()
        {
            return View();
        }

        public ActionResult RegisterForm()
        {
            return View();
        }

        //Hosted web API REST Service base url  
        string Baseurl = "http://192.168.72.13:8080/";

        public async Task<ActionResult> Register(FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                User user = new User();
                List<User> UserInfo = new List<User>();
                if (!collection["username"].Equals("") &&
                    !collection["name"].Equals("") &&
                    !collection["surname"].Equals("") &&
                    !collection["mail"].Equals("") &&
                    !collection["password"].Equals(""))
                {

                    user.username = collection["username"];
                    user.name = collection["name"];
                    user.surname = collection["surname"];
                    user.mail = collection["mail"];
                    user.password = collection["password"];

                    //Passing service base url  
                    client.BaseAddress = new Uri(Baseurl);

                    client.DefaultRequestHeaders.Clear();
                    //Define request data format  
                    client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                    HttpResponseMessage Res = await client.GetAsync("api/users");

                    //Checking the response is successful or not which is sent using HttpClient  
                    if (Res.IsSuccessStatusCode)
                    {
                        //Storing the response details recieved from web api   
                        var UserResponse = Res.Content.ReadAsStringAsync().Result;

                        //Deserializing the response recieved from web api and storing into the Employee list  
                        UserInfo = JsonConvert.DeserializeObject<List<User>>(UserResponse);

                    }
                    int max = 0;
                    foreach (User x in UserInfo)
                    {
                        if (x.num > max)
                        {
                            max = x.num;
                        }
                    }

                    user.num = max + 1;

                    await client.PostAsJsonAsync<User>("api/user/", user);

                    //returning the employee list to view  
                    return RedirectToAction("../Home/Index");

                }
                else
                {
                    return RedirectToAction("../Login/RegisterForm");
                }

            }
        }
    }
}