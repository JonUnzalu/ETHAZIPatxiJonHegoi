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
    public class HomeController : Controller
    {

        public ActionResult Index()
        {
            return View();
        }

        //Hosted web API REST Service base url  
        string Baseurl = "http://192.168.72.13:8080/";

        public async Task<ActionResult> Select()
        {
            List<Book> BookInfo = new List<Book>();
            using (var client = new HttpClient())
            {
                //Passing service base url  
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format  
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //Sending request to find web api REST service resource GetAllEmployees using HttpClient  
                HttpResponseMessage Res = await client.GetAsync("api/books");

                //Checking the response is successful or not which is sent using HttpClient  
                if (Res.IsSuccessStatusCode)
                {
                    //Storing the response details recieved from web api   
                    var BookResponse = Res.Content.ReadAsStringAsync().Result;

                    //Deserializing the response recieved from web api and storing into the Employee list  
                    BookInfo = JsonConvert.DeserializeObject<List<Book>>(BookResponse);

                }
                //returning the employee list to view  
                return View(BookInfo);
            }
        }

        public ActionResult InsertForm()
        {

            return View();
        }

        public async Task<ActionResult> Insert(FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                Book book = new Book();
                if (!collection["num"].Equals("") && int.TryParse(collection["num"], out int num) &&
                    !collection["author"].Equals("") &&
                    !collection["country"].Equals("") &&
                    !collection["imageLink"].Equals("") &&
                    !collection["language"].Equals("") &&
                    !collection["link"].Equals("") &&
                    !collection["pages"].Equals("") && int.TryParse(collection["pages"], out int pages) &&
                    !collection["title"].Equals("") &&
                    !collection["year"].Equals("") && int.TryParse(collection["year"], out int year))
                {
                    
                    book.num = int.Parse(collection["num"]);
                    book.author = collection["author"];
                    book.country = collection["country"];
                    book.imageLink = collection["imageLink"];
                    book.language = collection["language"];
                    book.link = collection["link"];
                    book.pages = int.Parse(collection["pages"]);
                    book.title = collection["title"];
                    book.year = int.Parse(collection["year"]);



                    //Passing service base url  
                    client.BaseAddress = new Uri(Baseurl);

                    client.DefaultRequestHeaders.Clear();
                    //Define request data format  
                    client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                    //Sending request to find web api REST service resource GetAllEmployees using HttpClient
                    await client.PostAsJsonAsync<Book>("api/book/", book);

                    //returning the employee list to view  
                    return RedirectToAction("../Home/Select");
                }
                else
                {
                    ViewBag.Message = "a";
                    return RedirectToAction("../Home/Insert");
                }

            }
        }

        public async Task<ActionResult> Delete(int num)
        {
            using (var client = new HttpClient())
            {

                //Passing service base url  
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format  
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //Sending request to find web api REST service resource GetAllEmployees using HttpClient  
                await client.DeleteAsync("api/book/delete/" + num);

                //returning the employee list to view  
                return RedirectToAction("../Home/Select");

            }
        }
    }
}