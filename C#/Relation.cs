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
            Console.WriteLine("\n Performing Logical operations "); 
            Boolean oper1, oper2; 
            oper1 = true; 
            oper2 = false; 
            Boolean ans1, ans2; 
            ans1 = oper1 & oper2; 
            ans2 = oper1 | oper2; 
            Console.WriteLine("The oper1 is: " + oper1); 
            Console.WriteLine("The oper2 is: " + oper2); 
            Console.WriteLine("The oper1&oper2 is: " + ans1); 
            Console.WriteLine("The oper1|oper2 is: " + ans2); 
            Console.ReadKey(); 
        } 
    } 
}