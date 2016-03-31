<%-- 
    Document   : New_Customer
    Created on : Mar 29, 2016, 11:22:44 PM
    Author     : Annie
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>TOBA Titan Online Banking Application</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <div><h1>TOBA Titan Online Banking Application</h1></div>
        <div><h2>Register for Online Banking Services</h2></div>
        <p>To register for Online Banking Services, enter 
            information below.</p>
        <p><i>${message}</i></p>
        <form method="post" action="addCustomer">
            <input type="hidden" name="action" value="add">        
            <label class="pad_top">First Name:</label>
            <input type="text" name="firstName"><br>
            <label class="pad_top">Last Name:</label>
            <input type="text" name="lastName"><br>
            <label class="pad_top">Phone:</label>
            <input type="text" name="phone"><br>
            <label class="pad_top">Address:</label>
            <input type="text" name="address"><br>  
            <label class="pad_top">City:</label>
            <input type="text" name="city"><br>
            <label class="pad_top">State:</label>
            <input type="text" name="state"><br>  
            <label class="pad_top">Zip Code:</label>
            <input type="text" name="zipCode"><br>
            <label class="pad_top">Email:</label>
            <input type="email" name="email"><br>
            <label>&nbsp;</label>
            <input type="submit" value="Submit" class="margin_left">
        </form>
    </body>
</html>
