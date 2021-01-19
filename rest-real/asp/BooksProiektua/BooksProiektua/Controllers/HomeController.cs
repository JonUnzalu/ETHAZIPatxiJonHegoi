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
    public class HomeController : Controller
    {

        public ActionResult Index()
        {
            return View();
        }

        //Hosted web API REST Service base url  
        string Baseurl = "http://192.168.72.13:8080/";

        public async Task<ActionResult> Select(int action, int id)
        {
            List<Book> BookInfo = new List<Book>();
            using (var client = new HttpClient())
            {
                //Passing service base url  
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format  
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                if (action == 1)
                {
                    
                }

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

        public async Task<ActionResult> Insert()
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

        public async Task<ActionResult> Delete(int num)
        {
            return View();
        }
    }
}