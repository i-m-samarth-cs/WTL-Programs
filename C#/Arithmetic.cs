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
  Console.WriteLine("Arithmetic Operations"); 
            int a = 20; 
            int b = 10; 
            int c; 
            Console.WriteLine("a = " + a); 
            Console.WriteLine("b = " + b); 
            c = a + b; 
            Console.WriteLine("Addition of two numbers..."+c); 
            c = a - b; 
            Console.WriteLine("Subtraction of two numbers..." + c); 
            c = a * b; 
            Console.WriteLine("Multiplication of two numbers..." + c); 
            c = a / b; 
            Console.WriteLine("Division of two numbers..." + c); 
 
            Console.ReadKey(); 
        } 
    } 
}