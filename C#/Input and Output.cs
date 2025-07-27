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
            Console.WriteLine("Enter your name: "); 
            String name = Console.ReadLine(); 
            Console.WriteLine("You have entered..."+name); 
            Console.ReadKey(); 
        } 
    } 
}