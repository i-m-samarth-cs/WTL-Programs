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
            Console.WriteLine("\n Performing Conditional operations "); 
            int a, b, c; 
            a = 10; 
            b = 20; 
            Console.WriteLine("a = " + a); 
            Console.WriteLine("b = " + b); 
            c = a > b ? a : b; 
            Console.WriteLine(c + " is greatest"); 
            Console.ReadKey(); 
        } 
    } 
}