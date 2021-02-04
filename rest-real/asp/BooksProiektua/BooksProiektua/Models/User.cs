using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BooksProiektua.Models
{
    public class User
    {
        public static Boolean loged { get; set; }
        public int num { get; set; }
        public String username { get; set; }
        public String name { get; set; }
        public String surname { get; set; }
        public String mail { get; set; }
        public String password { get; set; }
        public Boolean admin { get; set; }

        public String toString()
        {
            return "User {num = " + num + ", username = " + username + ", name = " + name + ", surname = " + surname + ", mail = " + mail + ", password = " + password + "}";
        }
    }
}