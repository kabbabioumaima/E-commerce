<%-- 
    Document   : register
    Created on : 17 nov. 2022, 18:10:51
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- === Coding by CodingLab | www.codinglabweb.com === -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- ===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <!-- ===== CSS ===== -->
    <link rel="stylesheet" href="style/style.css">
         
    <!--<title>Login & Registration Form</title>-->
    <style>
       
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body{
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #56baed;
}

.container{
    position: relative;
    max-width: 430px;
    width: 100%;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    margin: 0 20px;
}

.container .forms{
    display: flex;
    align-items: center;
    height: 440px;
    width: 200%;
    transition: height 0.2s ease;
}


.container .form{
    width: 50%;
    padding: 30px;
    background-color: #fff;
    transition: margin-left 0.18s ease;
}

.container.active .login{
    margin-left: -50%;
    opacity: 0;
    transition: margin-left 0.18s ease, opacity 0.15s ease;
}

.container .signup{
    opacity: 0;
    transition: opacity 0.09s ease;
}
.container.active .signup{
    opacity: 1;
    transition: opacity 0.2s ease;
}

.container.active .forms{
    height: 600px;
}
.container .form .title{
    position: relative;
    font-size: 27px;
    font-weight: 600;
}

.form .title::before{
    content: '';
    position: absolute;
    left: 0;
    bottom: 0;
    height: 3px;
    width: 30px;
    background-color: #4070f4;
    border-radius: 25px;
}

.form .input-field{
    position: relative;
    height: 30px;
    width: 100%;
    margin-top: 30px;
}

.input-field input{
    position: absolute;
    height: 100%;
    width: 100%;
    padding: 0 35px;
    border: none;
    outline: none;
    font-size: 16px;
    border-bottom: 2px solid #ccc;
    border-top: 2px solid transparent;
    transition: all 0.2s ease;
}

.input-field input:is(:focus, :valid){
    border-bottom-color: #4070f4;
}

.input-field i{
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    color: #999;
    font-size: 23px;
    transition: all 0.2s ease;
}

.input-field input:is(:focus, :valid) ~ i{
    color: #4070f4;
}

.input-field i.icon{
    left: 0;
}
.input-field i.showHidePw{
    right: 0;
    cursor: pointer;
    padding: 10px;
}

.form .checkbox-text{
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 20px;
}

.checkbox-text .checkbox-content{
    display: flex;
    align-items: center;
}

.checkbox-content input{
    margin-right: 10px;
    accent-color: #4070f4;
}

.form .text{
    color: #333;
    font-size: 14px;
}

.form a.text{
    color: #4070f4;
    text-decoration: none;
}
.form a:hover{
    text-decoration: underline;
}

.form .button{
    margin-top: 35px;
}

.form .button input{
    border: none;
    color: #fff;
    font-size: 17px;
    font-weight: 500;
    letter-spacing: 1px;
    border-radius: 6px;
    background-color: #4070f4;
    cursor: pointer;
    transition: all 0.3s ease;
}

.button input:hover{
    background-color: #265df2;
}

.form .login-signup{
    margin-top: 30px;
    text-align: center;
}

    </style>
</head>
<body>
    <form method="post" action="InscriptionController">
   

            <!-- Registration Form -->
            <div class="form signup">
                <span class="title">Registration</span>

                <form action="#">
                    <div class="input-field">
                        
                        <input type="text" name="nom" value="" placeholder="Enter your Last name" />
                        <i class="uil uil-user"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="prenom" value="" placeholder="Enter your First name"/>
                        <i class="uil uil-user"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="tele" value="" placeholder="Enter your Phone" />
                        <i class="uil uil-phone"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="adresse" value="" placeholder="Enter your adress" />
                         <i class="uil uil-envelope icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="email" value="" placeholder="Enter your email" />
                        <i class="uil uil-envelope icon"></i>
                    </div>
                    <div class="input-field">
                       <input type="password" name="password" value="" placeholder="Enter your password"/>
                        <i class="uil uil-lock icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="password" class="password" placeholder="Confirm a password" required>
                        <i class="uil uil-lock icon"></i>
                        <i class="uil uil-eye-slash showHidePw"></i>
                    </div>

                    <div class="checkbox-text">
                        <div class="checkbox-content">
                            <input type="checkbox" id="termCon">
                            <label for="termCon" class="text">I accepted all terms and conditions</label>
                        </div>
                    </div>

                    <div class="input-field button">
                      <input type="submit" value="signup" />
                      
                    </div>
                </form>

                <div class="login-signup">
                    <span class="text">Already a member?
                        <a href="#" class="text login-link">Login Now</a>
                    </span>
                </div>
            </div>
        </div>
    </div>

    <script src="script.js"></script>
    </form>
</body>
</html>