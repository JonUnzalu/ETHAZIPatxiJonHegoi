using BooksProiektua.Models;
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
        //Hosted web API REST Service base url  
        string Baseurl = "http://192.168.72.13:8080/";

        public ActionResult LoginForm()
        {
            return View();
        }

        public async Task<ActionResult> Login(FormCollection collection)
        {
            List<User> userInfo = new List<User>();
            Boolean found = false;
            using (var client = new HttpClient())
            {
                string username = collection["username"];
                string password = collection["password"];
                //Passing service base url
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //Sending request to find web api REST service resource GetAllEmployees using HttpClient
                HttpResponseMessage Res = await client.GetAsync("api/users");

                //Checking the response is successful or not which is sent using HttpClient
                if (Res.IsSuccessStatusCode)
                {
                    //Storing the response details recieved from web api   
                    var UserResponse = Res.Content.ReadAsStringAsync().Result;

                    //Deserializing the response recieved from web api and storing into the Employee list  
                    userInfo = JsonConvert.DeserializeObject<List<User>>(UserResponse);

                    int i = 0;
                    while (!found && i < userInfo.Count)
                    {
                        if (userInfo[i].username.Equals(username))
                        {
                            if (userInfo[i].password.Equals(password))
                            {
                                found = true;
                            } else
                            {
                                i++;
                            }
                        }
                        else
                        {
                            i++;
                        }
                    }
                    if (found)
                    {
                        return RedirectToAction("../Home/Index");
                    }
                    else
                    {
                        return RedirectToAction("../Login/LoginForm");
                    }


                }

                else
                {
                    return RedirectToAction("../Login/LoginForm");
                }
            }
        }

        public ActionResult RegisterForm()
        {
            return View();
        }

        public async Task<ActionResult> Register(FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                User user = new User();
                List<User> UserInfo = new List<User>();
                if (!collection["username"].Equals("") &&
                    !collection["name"].Equals("") &&
                    !collection["surname"].Equals("") &&
                    !collection["mail"].Equals("") && collection["mail"].Contains("@") && collection["mail"].Contains(".") &&
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