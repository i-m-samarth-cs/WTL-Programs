<%@ Page Language="C#"  %> 
<script  runat="server"> 
void Button1_Click(object sender, EventArgs e) 
{ 
    Label1.Text = "You have clicked the Button"; 
} 
</script> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head runat="server"> 
    <title></title> 
</head> 
<body> 
    <form id="form1" runat="server"> 
    <div> 
        <asp:Label ID="Label1" runat="server"></asp:Label> 
    </div> 
    <div> 
           <asp:Button ID="Button1" runat="server" Type="submit" onclick="Button1_Click" 
Text="Click" /> 
     </div> 
    </form> 
</body> 
</html> 