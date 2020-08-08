<html>
<body>
<h3>
The UI of this project uses: 
    <li>Apache Tomcat</li>
    <li>Maven</li>
    <li>MySQL</li>
</h3>
<h2>Apache Tomcat:</h2>
<p>

- Download <a href="https://tomcat.apache.org/download-90.cgi" target="_blank">Apache Tomcat 9</a>.<br>
- Apache Tomcat provides a good instructions on <a href="https://tomcat.apache.org/tomcat-9.0-doc/RUNNING.txt" target="_blank">how to run tomcat</a>.<br><br>
<br>
- Go to ‘apache-tomcat-9.0.35/conf’ open ‘tomcat-users.xml’ and in &#60tomcat-users&#62 &#60/tomcat-users&#62 add “<br>
&#60role rolename="manager-gui"/&#62<br>
&#60role rolename="manager-script"/&#62<br>
&#60user username="admin" password="password" roles="manager-gui,manager-script"/&#62<br>
“<br>
(and make sure it’s not in a comment (&#60!-- --&#62))<br>
<br>
---------------------------------------------------------------<br>
Here's a good <a href="https://tomcat.apache.org/tomcat-9.0-doc/index.html" target="_blank">documentation</a> about Tomcat 9.<br>
---------------------------------------------------------------<br>
</p>

<h2>Maven:</h2>
<p>
- To install maven here is a <a href="https://maven.apache.org/install.html" target="_blank">link</a> to guide you through the installation proccess.<br>
After installing maven:<br>
- To go to '.m2' folder open the terminal and run 'open .m2'.<br>
- There should be a 'settings.xml' file, if not you can create a 'settings.xml' and here's a <a href="https://maven.apache.org/settings.html" target="_blank">link</a> on how to setup the settings file.<br>
- Open ‘setting.xml’ file and in &#60servers&#62 &#60/servers&#62 add “<br>
&#60server&#62<br>
	&#60id&#62TomcatServer&#60/id&#62<br>
	&#60username&#62admin&#60/username&#62<br>
	&#60password&#62password&#60/password&#62<br>
&#60/server&#62<br>
“
</p>

<h2>MySQL:</h2>
<p>
We used MySQL to store our data so that our operations won't be deleted when we restart the project.<br>
- To Download MySQL (<a href="https://dev.mysql.com/downloads/shell/" target="_blank">link</a>)<br>
 After Downloading MySQL:<br> 
- To run MySQL here is a <a href="https://dev.mysql.com/doc/mysql-getting-started/en/" target"_blank">link</a> that provide all the information needed on how to start MySQL.<br>
- After starting MySQL, create a database named (HR).<br>
<br>
--------------------------------------------------------------<br>
A good application to show your database is MySQL Workbench (<a href="https://dev.mysql.com/downloads/workbench/" target="_blank">download</a>).<br>
<a href="https://dev.mysql.com/doc/refman/8.0/en/" target="_blank">MySQL documentation</a><br>
<a href="https://dev.mysql.com/doc/workbench/en/" target="_blank">MySQL Workbench documentation</a><br>
---------------------------------------------------------------<br>
</p>
<h2>Running The Project:</h2>
<p>
You’ll have to use three terminal windows.<br>
- On the first terminal window move to ‘hrm’ folder and do a ‘mvn install’.<br>
- On the second terminal window go to ‘apache-tomcat-9.0.35/bin’ folder and run ‘./catalina.sh start’.<br>
- On the first terminal window move to ‘HRsystem’ folder and run ‘mvn install tomcat7:deploy’.<br>

- open ‘hrm/HRsystem/WebContent/WEB-INF’ folder and copy all .html and .css files and paste it in ‘apache-tomcat-9.0.35/webapps/HRsystem/WEB-INF/classes’.<br>
- open the third terminal window and move to ‘hrm’ directory.<br>
- open your browser, the link to the project is ‘http://localhost:8080/HRsystem/home/page/web’, go to the third terminal window and run ‘bash run.sh’ (you'll have to run it within 5 seconds so that the project can connect to the socket port).<br>
</p>

</body>
</html>
