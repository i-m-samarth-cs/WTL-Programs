<%@ Page Language="C#" %> 
<script  runat="server"> 
void Button1_Click(object sender, EventArgs e) 
{ 
    Label1.Text ="Welcome "+ TextBox1.Text+ "!!!";   
} 
</script> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head runat="server"> 
    <title>TextBox Control</title>
    </head> 
<body> 
    <form id="form1" runat="server"> 
    <div> 
       <asp:Label ID="Label1" runat="server" Text="Enter Some Text in the TextBox 
"></asp:Label> 
    </div> 
    <div> 
    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox> 
    </div> 
    <div> 
    <asp:Button ID="Button1" runat="server" onclick="Button1_Click" Text="Click" /> 
    </div> 
    </form> 
</body> 
</html>