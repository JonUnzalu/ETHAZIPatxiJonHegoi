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

        public async Task<ActionResult> Select(int i = 0)
        {
            List<Book> BookInfo = new List<Book>();
            List<Book> BookList = new List<Book>();
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
                for (int k = i; k < i + 10 && k < BookInfo.Count; k++)
                {
                    BookList.Add(BookInfo[k]);
                }

                //returning the employee list to view  
                return View(BookList);
            }
        }

        public async Task<ActionResult> InsertForm()
        {
            List<Book> countries = new List<Book>();
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
                    countries = JsonConvert.DeserializeObject<List<Book>>(BookResponse);

                }

                //returning the employee list to view  
                return View(countries);
            }
        }

        public async Task<ActionResult> SelectOne(int num)
        {
            Book BookInfo = new Book();
            using (var client = new HttpClient())
            {
                //Passing service base url  
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format  
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //Sending request to find web api REST service resource GetAllEmployees using HttpClient  
                HttpResponseMessage Res = await client.GetAsync("api/book/num/" + num);

                //Checking the response is successful or not which is sent using HttpClient  
                if (Res.IsSuccessStatusCode)
                {
                    //Storing the response details recieved from web api   
                    var BookResponse = Res.Content.ReadAsStringAsync().Result;

                    //Deserializing the response recieved from web api and storing into the Employee list  
                    BookInfo = JsonConvert.DeserializeObject<Book>(BookResponse);

                }
                for (int i = 1; i < BookInfo.genres.Count; i++)
                {
                    BookInfo.genres[i] = ", " + BookInfo.genres[i];
                }
                //returning the employee list to view  
                return View(BookInfo);
            }
        }

        public async Task<ActionResult> Insert(FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                Book book = new Book();
                List<Book> BookInfo = new List<Book>();
                if (!collection["author"].Equals("") &&
                    !collection["country"].Equals("") &&
                    !collection["imageLink"].Equals("") &&
                    !collection["language"].Equals("") &&
                    !collection["link"].Equals("") &&
                    !collection["pages"].Equals("") &&
                    !collection["title"].Equals("") &&
                    !collection["year"].Equals(""))
                {
                    if (int.TryParse(collection["pages"], out int pages) && int.TryParse(collection["year"], out int year))
                    {
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

                        HttpResponseMessage Res = await client.GetAsync("api/books");

                        //Checking the response is successful or not which is sent using HttpClient  
                        if (Res.IsSuccessStatusCode)
                        {
                            //Storing the response details recieved from web api   
                            var BookResponse = Res.Content.ReadAsStringAsync().Result;

                            //Deserializing the response recieved from web api and storing into the Employee list  
                            BookInfo = JsonConvert.DeserializeObject<List<Book>>(BookResponse);

                        }
                        int max = 0;
                        foreach (Book x in BookInfo)
                        {
                            if (x.num > max)
                            {
                                max = x.num;
                            }
                        }

                        book.num = max + 1;

                        await client.PostAsJsonAsync<Book>("api/book/", book);

                        //returning the employee list to view  
                        return RedirectToAction("../Home/Select");
                    }
                    else
                    {
                        return RedirectToAction("../Home/InsertForm");
                    }
                }
                else
                {
                    return RedirectToAction("../Home/InsertForm");
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