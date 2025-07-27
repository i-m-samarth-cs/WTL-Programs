<%@ Page Language="C#" AutoEventWireup="true" %>
 
<script runat="server"> 
void CheckBox1_CheckedChanged(object sender, EventArgs e) 
{ 
    if (CheckBox1 .Checked==true) 
    { 
        ListBox1.Items.Add(CheckBox1.Text); 
    } 
    else 
    { 
        ListBox1.Items.Remove(ListBox1.Items.FindByText(CheckBox1.Text)); 
    } 
} 
void CheckBox2_CheckedChanged(object sender, EventArgs e) 
{ 
    if (CheckBox2.Checked == true) 
    { 
        ListBox1.Items.Add(CheckBox2.Text); 
    } 
    else 
    { 
        ListBox1.Items.Remove(ListBox1.Items.FindByText(CheckBox2.Text)); 
    } 
} 
void CheckBox3_CheckedChanged(object sender, EventArgs e) 
{ 
    if (CheckBox3.Checked == true) 
    { 
        ListBox1.Items.Add(CheckBox3.Text); 
    } 
    else 
    { 
        ListBox1.Items.Remove(ListBox1.Items.FindByText(CheckBox3.Text)); 
    } 
} 
</script> 
 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head runat="server"> 
    <title></title> 
</head>
<body> 
    <form id="form1" runat="server"> 
    <div> 
         <asp:CheckBox ID="CheckBox1" runat="server" AutoPostBack="True"   
            oncheckedchanged="CheckBox1_CheckedChanged" Text="C++" /> 
     
    </div> 
    <div> 
        <asp:CheckBox ID="CheckBox2" runat="server" AutoPostBack="True"   
            oncheckedchanged="CheckBox2_CheckedChanged" Text="Java" /> 
    </div> 
    <div> 
        <asp:CheckBox ID="CheckBox3" runat="server" AutoPostBack="True"   
            oncheckedchanged="CheckBox3_CheckedChanged" Text="C#" /> 
    </div> 
    <div> 
    <asp:ListBox ID="ListBox1" runat="server"  Height="140px" Width="120px"> 
    </asp:ListBox> 
    </div> 
    </form> 
</body> 
</html> 