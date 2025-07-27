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
            int i, count = 5; 
            for (i = 0; i < 10; i++)
              { 
                if (i == count) 
                { 
                    continue; 
                } 
                Console.WriteLine("\n i = " + i); 
            } 
            Console.ReadKey(); 
        } 
    } 
} 