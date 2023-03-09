<html>
<body>
<h2>Hello... Welcome to Spring boot test!</h2>
<form action="fileUpload" method="post" enctype="multipart/form-data">
    <label>Enter file info</label>
    <input type="text" name="fileInfo"/>
    <br>
    <input type="file" name="actualFile"/>
    <br>
    <button type="submit">Submit</button>
</form>

<br>
<hr>
<form action="imageUpload" method="post" enctype="multipart/form-data">
    <label>Upload Image</label>
    <input type="file" name="img"/>
    <br>
    <button type="submit">Click</button>
</form>

</body>
</html>