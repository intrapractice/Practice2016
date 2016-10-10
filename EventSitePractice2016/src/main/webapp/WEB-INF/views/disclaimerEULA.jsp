<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
        <title>Login</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="/EventSitePractice2016/resources/js/loginScript.js"></script>
        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/headerFooterEventDetailsPage.css">
        <link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/LoginPageStyle.css">
        <link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/disclaimerEULA.css">
    </head>
    <body id="background">
        <div class="head">
            <nav class="list">
            <li>
                <div><img id="logoSize" src="/EventSitePractice2016/resources/images/logo.png"/></div>
            </li>
            <li>
                <a class="active" href="/EventSitePractice2016/login">
                    <div style="transform: skewX(15deg)">SIGN IN</div>
                </a>
            </li>
            <li>
                <a href="/EventSitePractice2016/">
                    <div style="transform: skewX(15deg)">EVENTS</div>
                </a>
            </li>
            <div class="dropdown">
                <div class="dropskew">
                    <div class="dropskew2">
                        <button class="dropbtn"><img src="/EventSitePractice2016/resources/images/dropdown.png"/></button>
                    </div>
                </div>
                <div class="dropdown-content">
                    <a href="/EventSitePractice2016/login">SIGN IN</a>
                    <a href="/EventSitePractice2016/">EVENTS</a>
                    <a href="http://www.intracol.com/">
                        <img id="intra" src="/EventSitePractice2016/resources/images/Intarcol-logo.png">
                    </a>
                    <a href="http://bulpros.com/">
                        <img id="bul" src="/EventSitePractice2016/resources/images/bulpros-logo.png">
                    </a>
                    <a href="http://www.tu-sofia.bg/">
                        <img id="tus" src="/EventSitePractice2016/resources/images/tu-logo.png">
                    </a>
                </div>
            </div>

        </nav>

    </div>
    <div class="disclaimerAndEULAContainer">
        <div id="disclaimer">
            <div class="disclaimerAndEULAHeading">
                <h4>DISCLAIMER</h4>
            </div>
            <p>
                The following software is a student's project, developed as part of partnership agreement between Technical University Sofia, Intracol Technologies and Bulpros. It was developed from a team of students, organized, supervised and supported by Intracol
                Technologies Engineers. The design was provided by Bulpros. This system is no intended to be used for commercial purposes. The source code of the project is not proprietary and is publically available on the following URL:
                <a href="https://github.com/intrapractice/Practice2016" target="_blank">https://github.com/intrapractice/Practice2016</a>
                <br/>
                TU Students involved in the development team:<br/>
            </p>
            <ol>
                <li>Angel Botev</li>
                <li>Borislav Borisov</li>
                <li>Victoria Grozdancheva</li>
                <li>Denitza Kavalska</li>
                <li>Martin Mihaylov</li>
                <li>Hristian Stoyanov</li>
            </ol>
        </div>
        <div id="EULA">
            <div class="disclaimerAndEULAHeading">
                <h4>END-USER LICENSE AGREEMENT</h4>
            </div>
            <p>
                YOU SHOULD CAREFULLY READ THE FOLLOWING TERMS AND CONDITIONS BEFORE USING THIS PRODUCT. This End User License Agreement for the "Event Harbor" students' project is a legal agreement between you (either an individual or an entity) and Intracol
                Technologies and its suppliers and licensors. The Software may include on-line services using wire/wireless networks and any combination of such products and Alpha, Beta, trial, pre-release, free, pay and premium versions of the products. By using
                the Software, you agree to be bound by the terms of this License Agreement. IF YOU DO NOT AGREE TO THE TERMS OF THIS LICENSE AGREEMENT, CLOSE THE BROWSER TAB AND DO NOT USE THIS SOFTWARE.
            </p>
            <p>
                <div class="disclaimerAndEULAHeading">
                    <h4>1. GRANT OF LICENSE.</h4>
                </div>
                a) The Software is free for non-commercial use and has no functional restrictions. You may use the Software for your personal use at home and in any non-commercial organization. You may not use the Software in any way to provide, or as part of, any
                commercial service or application. b) You agree that you shall only use the Software in a manner that complies with all applicable laws in the jurisdictions in which you use the Software, including, but not limited to, applicable restrictions
                concerning copyright and other intellectual property rights. c) You may not use the Software in an attempt to, or in conjunction with, any device, program or service designed to circumvent technological measures employed to control access to, or the
                rights in, a content file or other work protected by the copyright laws of any jurisdiction.
            </p>
            <p>
                <div class="disclaimerAndEULAHeading">
                    <h4>2. RIGHTS.</h4>
                </div>
                Title, ownership, rights, and intellectual property rights in and to the Software shall remain in Intracol Technologies. The Software is protected by the copyright laws of international copyright treaties. Title, ownership, rights, and intellectual
                property rights in and to the content accessed through the Software and the Services ("Content") including the content contained in the Software, shall be retained by the applicable Content owner and may be protected by applicable copyright or other
                law. This license gives you no rights to such Content.
            </p>
            <p>
                <div class="disclaimerAndEULAHeading">
                    <h4>3. LIABILITY.</h4>
                </div>
                THIS SOFTWARE IS DISTRIBUTED "AS IS" AND WITHOUT WARRANTIES AS TO PERFORMANCE OF MERCHANTABILITY OR ANY OTHER WARRANTIES WHETHER EXPRESSED OR IMPLIED. YOU USE IT AT YOUR OWN RISK. INTRACOL TEHCNOLOGIES WILL NOT BE LIABLE FOR DATA LOSS, DAMAGES, LOSS
                OF PROFITS OR ANY OTHER KIND OF LOSS WHILE USING OR MISUSING THIS SOFTWARE.
            </p>
            <p>
                <div class="disclaimerAndEULAHeading">
                    <h4>4. TERMINATION.</h4>
                </div>
                This License Agreement will automatically terminate if you fail to comply with any term hereof. No notice shall be required from Intracol Technologies to effect such termination. Upon any termination of this License Agreement, you shall immediately
                discontinue use of the Software. Your responsibilities for any content that you have already posted into the Software shall survive any termination of this License Agreement.

            </p>
        </div>
        <button class="acceptButton" onclick="acceptLicenseAgreement()">Accept</button>
    </div>
    <jsp:include page="footer.jsp"/>
</body>

</html>
