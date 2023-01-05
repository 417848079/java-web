<%--
  Created by IntelliJ IDEA.
  User: amw
  Date: 2023/1/5
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">

<head>
    <!-- meta data -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!--font-family-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext"
          rel="stylesheet">

    <!-- title of site -->
    <title>Sign in</title>

    <!-- For favicon png -->
    <link rel="shortcut icon" type="image/icon" href="assets/logo/favicon.png"/>

    <!--font-awesome.min.css-->
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">

    <!--animate.css-->
    <link rel="stylesheet" href="assets/css/animate.css">

    <!--bootstrap.min.css-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <!-- bootsnav -->
    <link rel="stylesheet" href="assets/css/bootsnav.css">

    <!--style.css-->
    <link rel="stylesheet" href="assets/css/style.css">

    <!--responsive.css-->
    <link rel="stylesheet" href="assets/css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

    <!--[if lt IE 9]>
    <script src="assets/download/js/html5shiv.min.js"></script>
    <script src="assets/download/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<!--[if lte IE 9]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade
    your browser</a> to improve your experience and security.</p>
<![endif]-->

<!-- signin end -->
<section class="signin">
    <div class="container">

        <div class="sign-content">

            <h2>login</h2>
            <div class="row">
                <div class="col-sm-12">
                    <div class="signin-form">
                        <form action="/brand-demo/loginServlet" method="post" name="formData">
                            <div class="form-group">
                                <label for="signin_form">user</label>
                                <input type="email"  class="form-control" name="username" id="signin_form"
                                       placeholder="enter your email here" value="${cookie.username.value}">
                            </div><!--/.form-group -->
                            <div class="form-group">
                                <label for="signin_form">password</label>
                                <input type="password" class="form-control" name="password" id="signin_form"
                                       placeholder="Password" value="${cookie.password.value}">
                            </div><!--/.form-group -->
                            <div style="margin-top: 30px">
                                <input class="styled-checkbox" id="styled-checkbox-2" type="checkbox"
                                       value="1" name="remember">
                                <label for="styled-checkbox-2">remember password</label>
                            </div>
                        </form><!--/form -->
                    </div><!--/.signin-form -->
                </div><!--/.col -->
            </div><!--/.row -->

            <div class="row">
                <div class="col-sm-12">
                    <div class="signin-password">
                        <div class="awesome-checkbox-list">
                            <ul class="unstyled centered">



                                <li>
                                    <a href="#">Forgot email or password ?</a>
                                </li>

                            </ul>
                        </div><!--/.awesome-checkbox-list -->
                    </div><!--/.signin-password -->
                </div><!--/.col -->
            </div><!--/.row -->

            <div class="row">
                <div class="col-sm-12">
                    <div class="signin-footer">
                        <button type="button" class="btn signin_btn" data-toggle="modal"
                                onclick="submitFun(document.formData)">
                            sign in
                        </button>
                        <div id="errorMsg" style="margin-top: 20px;">
                            <h3 style="color: red;text-align: center">${login_msg} ${register_msg}</h3></div>
                        <p>
                            Don’t have an Account ?
                            <a href="register.jsp">register</a>
                        </p>
                    </div><!--/.signin-footer -->
                </div><!--/.col-->
            </div><!--/.row -->

        </div><!--/.sign-content -->

        <!-- modal part start -->
        <div class="modal fade signin_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="sign-content">

                        <div class="modal-header">
                            <h2>sign in</h2>
                        </div><!--/.modal-header -->

                        <div class="modal-body">
                            <div class="signin-form">
                                <div class=" ">
                                    <div class=" ">
                                        <form action="signin.html">
                                            <div class="form-group">
                                                <label for="signin_form">Email</label>
                                                <input type="email" class="form-control" id="signin_form"
                                                       placeholder="enter your email here">
                                            </div><!--/.form-group -->
                                            <div class="form-group">
                                                <label for="signin_form">password</label>
                                                <input type="password" class="form-control" id="signin_form"
                                                       placeholder="Password">
                                            </div><!--/.form-group -->
                                        </form><!--/form -->
                                    </div><!--/.col -->
                                </div><!--/.row -->

                            </div><!--/.signin-form -->

                            <div class="signin-modal-password">
                                <div class="awesome-checkbox-list">
                                    <ul class="unstyled centered">

                                        <li>
                                            <input class="styled-checkbox" id="styled-checkbox-3" type="checkbox"
                                                   value="value3">
                                            <label for="styled-checkbox-3">remember password</label>
                                        </li>

                                        <li>
                                            <a href="signin.html">Forgot email or password ?</a>
                                        </li>

                                    </ul>
                                </div><!--/.awesome-checkbox-list -->
                            </div><!--/.signin-modal-password -->

                            <div class="signin-footer">
                                <button type="button" class="btn signin_btn" data-toggle="modal"
                                        data-target=".signin_modal">
                                    sign in
                                </button>
                                <p>
                                    Don’t have an Account ?
                                    <a href="signup.html">register</a>
                                </p>
                            </div><!--/.signin-footer -->
                        </div><!--/.modal-body -->

                    </div><!--/.sign-content -->
                </div><!--/.modal-content -->
            </div><!--/.modal-dialog -->
        </div><!--/.modal -->
        <!-- modal part end -->
    </div><!--/.container -->

</section><!--/.signin -->

<!-- signin end -->

<!--footer copyright start -->
<footer class="footer-copyright">
    <div id="scroll-Top">
        <i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top"
           title="" data-original-title="Back to Top" aria-hidden="true"></i>
    </div><!--/.scroll-Top-->

</footer><!--/.hm-footer-copyright-->
<!--footer copyright  end -->


<!-- Include all js compiled plugins (below), or include individual files as needed -->

<script src="assets/js/jquery.js"></script>

<!--modernizr.min.js-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

<!--bootstrap.min.js-->
<script src="assets/js/bootstrap.min.js"></script>

<!-- bootsnav js -->
<script src="assets/js/bootsnav.js"></script>

<!-- jquery.sticky.js -->
<script src="assets/js/jquery.sticky.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>


<!--Custom JS-->
<script src="assets/js/custom.js"></script>

</body>
<script lang="javascript">
    function submitFun(obj) {
        obj.submit();
    }
</script>
</html>