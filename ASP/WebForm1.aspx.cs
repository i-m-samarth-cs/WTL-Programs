using System;
using System.Web.UI;

public partial class WebForm1 : Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // This method runs every time the page is loaded.
    }

    protected void Button1_Click(object sender, EventArgs e)
    {
        string name = TextBox1.Text;
        string address = TextBox2.Text;
        string phone = TextBox3.Text;

        // Display the user input as a browser alert
        Response.Write(string.Format("<script>alert('Name: {0}\\nAddress: {1}\\nPhone: {2}');</script>", name, address, phone));

    }
}
