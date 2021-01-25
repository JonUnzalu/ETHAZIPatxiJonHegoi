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

    }
}