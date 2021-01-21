using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web;

namespace BooksProiektua.Models
{
    public class Book
    {
        public String id { get; set; }
        public int num { get; set; }
        public String author { get; set; }
        public String country { get; set; }
        public String imageLink { get; set; }
        public String language { get; set; }
        public String link { get; set; }
        public int pages { get; set; }
        public String title { get; set; }
        public int year { get; set; }

        public String toString()
        {
            return "Book{ id = " + id + ", num = " + num + ", author = " + author + ", country = " + country +
                ", imageLink = " + imageLink + ", language = " + language + ", link = " + link +
                ", pages = " + pages + ", title = " + title + ", year = " + year + "}";
        }

    //    static HttpClient client = new HttpClient();

    //    static async Task<Uri> CreateProductAsync(Book book)
    //    {
    //        HttpResponseMessage response = await client.PostAsJsonAsync(
    //            "api/book", book);
    //        response.EnsureSuccessStatusCode();

    //        // return URI of the created resource.
    //        return response.Headers.Location;
    //    }

    //    static async Task<Book> GetProductAsync(string path)
    //    {
    //        Book book = null;
    //        HttpResponseMessage response = await client.GetAsync(path);
    //        if (response.IsSuccessStatusCode)
    //        {
    //            book = await response.Content.ReadAsAsync<Book>();
    //        }
    //        return book;
    //    }

    //    static async Task<Book> UpdateProductAsync(Book book)
    //    {
    //        HttpResponseMessage response = await client.PutAsJsonAsync(
    //            $"api/book/{book.num}", book);
    //        response.EnsureSuccessStatusCode();

    //        // Deserialize the updated product from the response body.
    //        book = await response.Content.ReadAsAsync<Book>();
    //        return book;
    //    }

    //    static async Task<HttpStatusCode> DeleteProductAsync(int num)
    //    {
    //        HttpResponseMessage response = await client.DeleteAsync(
    //            $"api/book/{num}");
    //        return response.StatusCode;
    //    }

    //    static void Main()
    //    {
    //        RunAsync().GetAwaiter().GetResult();
    //    }

    //    static async Task RunAsync()
    //    {
    //        // Update port # in the following line.
    //        client.BaseAddress = new Uri("http://localhost:64195/");
    //        client.DefaultRequestHeaders.Accept.Clear();
    //        client.DefaultRequestHeaders.Accept.Add(
    //            new MediaTypeWithQualityHeaderValue("application/json"));

    //        try
    //        {
    //            // Create a new product
    //            Book product = new Book
    //            {
    //                id = "aaaaa",
    //                num = 102,
    //                author = "aaaaaa",
    //                country = "aaaaaa",
    //                imageLink = "aaaaa",
    //                language = "aaaa",
    //                link = "aaaaa",
    //                pages = 1,
    //                title = "aaaaa",
    //                year = 1
    //            };

    //            var url = await CreateProductAsync(product);
    //            Console.WriteLine($"Created at {url}");

    //            // Get the product
    //            product = await GetProductAsync(url.PathAndQuery);
    //            Console.WriteLine(product.toString());

    //            // Update the product
    //            Console.WriteLine("Updating price...");
    //            product.pages = 80;
    //            await UpdateProductAsync(product);

    //            // Get the updated product
    //            product = await GetProductAsync(url.PathAndQuery);
    //            Console.WriteLine(product.toString());

    //            // Delete the product
    //            var statusCode = await DeleteProductAsync(product.num);
    //            Console.WriteLine($"Deleted (HTTP Status = {(int)statusCode})");

    //        }
    //        catch (Exception e)
    //        {
    //            Console.WriteLine(e.Message);
    //        }

    //        Console.ReadLine();
    //    }
    }
}