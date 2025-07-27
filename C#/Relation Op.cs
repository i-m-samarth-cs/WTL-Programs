using System; 
using System.Collections.Generic; 
using System.Linq; 
using System.Text;
namespace MyFirstApplication 
{ 
    class Program 
    { 
        static void Main(string[] args) 
        { 
            Console.WriteLine("\n Performing Relational operations "); 
            int a = 10, b = 20, c = 10; 
            Console.WriteLine("a= " + a); 
            Console.WriteLine("b= " + b); 
            Console.WriteLine("c= " + c); 
            Console.WriteLine("\n The a<b is " + (a < b)); 
            Console.WriteLine("\n The a>b is " + (a > b)); 
            Console.WriteLine("\n The a==c is " + (a == c)); 
            Console.WriteLine("\n The a<=b is " + (a <= b)); 
            Console.WriteLine("\n The a>=c is " + (a >= c)); 
            Console.WriteLine("\n The a!=b is " + (a != b)); 
            Console.ReadKey(); 
        } 
    } 
}