<%@ page contentType="text/html; charset = UTF-8" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>File Upload Example</title>
   </head>
   
   <body>
      <form:form method = "post" modelAttribute = "fileUpload" action="fileUploadPage"
         enctype = "multipart/form-data">
         Please select a file to upload : 
         <input type = "file" name = "multipartFile" /> <!-- should be the same name as the member variable in the FileModel.java -->
         <input type = "submit" value = "upload" />
      </form:form>
   </body>
</html>