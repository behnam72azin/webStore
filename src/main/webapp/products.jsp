
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>محصولات</title>
    <link rel="stylesheet" href="style/products.css">
</head>
<body>

<h1>فروشگاه آنلاین</h1>

<div class="product-container">
    <div class="product">
        <img src="img/pic1.webp" alt="powerbank">
        <div class="product-name">پاوربانک</div>
        <div class="product-price">1,000,000 تومان</div>
        <button onclick="addToList('powerBank')">افزودن به سبد خرید</button>
    </div>
    <div class="product">
        <img src="img/pic2.webp" alt="caddy">
        <div class="product-name">hdd caddy</div>
        <div class="product-price">400,000 تومان</div>
        <button onclick="addToList('hddcaddy')">افزودن به سبد خرید</button>
    </div>
    <div class="product">
        <img src="img/pic3.webp" alt="cable sata">
        <div class="product-name">کابل ساتا</div>
        <div class="product-price">200,000 تومان</div>
        <button onclick="addToList('sataCable')">افزودن به سبد خرید</button>
    </div>
</div>

<div style="text-align: center; margin-top: 20px;">
    <button onclick="showList()">خرید</button>
    <button onclick="logout()">خروج</button>
</div>



</body>
<script>
    const list = [];

    function addToList(productName) {
        list.push(productName);
        console.log(productName," به سبد خرید اضافه شد.");
    }

    function showList() {
        if (list.length === 0) {
            console.log("سبد خرید خالی است.");
        } else {
            console.log("محصولات انتخاب شده:");
            list.forEach((product, index) => {
                console.log((index + 1)+". "+product);
            });
        }
    }

    function logout() {
        window.location.href = "login.do";
    }
</script>
</html>

