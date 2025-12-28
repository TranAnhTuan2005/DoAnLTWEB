<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="style.css">
    <script src="script.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<style>
    .main-detailProduct {
        font-family: 'Tahoma', Arial, sans-serif;
        color: #444;
        background-color: #fff;
    }

    /* --- Breadcrumb --- */
    /* Tối ưu breadcrumb: giảm chiều cao và không xuống dòng */
    .breadcrumb-bar {
        padding-top: 5px;   /* giảm khoảng cách trên/dưới của thanh */
        padding-bottom: 5px;
        background: #f6efe3;
        border-bottom: 1px solid rgba(0,0,0,0.04);
    }

    /* Mỗi item không có margin dày (tránh làm nội dung tràn xuống dưới)*/
    .breadcrumb-bar .breadcrumb .breadcrumb-item {
        margin: 0;
        padding: 0;
    }

    /* Dấu phân cách (nếu muốn điều chỉnh kích thước/màu) */
    .breadcrumb-bar .breadcrumb .breadcrumb-item + .breadcrumb-item::before {
        content: "/";             /* đảm bảo ký tự phân cách luôn là / */
        margin: 0 6px;
        color: #8a7354;
        font-weight: 600;
    }

    /* Text các link và active */
    .breadcrumb-bar .breadcrumb a {
        color: #6d4c41;
        text-decoration: none;
        font-weight: 500;
    }
    .breadcrumb-bar .breadcrumb .active {
        color: #3b2d22;
        font-weight: 600;
    }



    /* ===== Layout chính ===== */
    .detail-product-page {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 60px;
        align-items: start;
        justify-content: center;
        max-width: 1300px;
        margin: 60px auto;
        padding: 0 40px;
    }

    /* ===== Hình ảnh sản phẩm ===== */
    .detail-product-gallery {
        max-width: 480px;
    }

    .detail-product-image {
        width: 100%;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }

    /* ===== Thông tin sản phẩm ===== */
    .detail-product-info {
        max-width: 1200px;
        margin-left: -100px;
        display: flex;
        flex-direction: column;
        gap: 5px;
    }

    .detail-product-title {
        font-size: 28px;
        font-weight: 700;
        margin-bottom: 10px;
        position: relative;
        display: inline-block;
        padding-bottom: 8px;
    }

    .detail-product-title::after {
        content: "";
        display: block;
        width: 100%;
        height: 3px;
        background-color: #839b4c;
        margin-top: 6px;
    }

    .detail-product-price {
        font-size: 22px;
        color: #e63946;
        font-weight: 700;
        margin-bottom: 20px;
    }

    .detail-product-quantity {
        display: inline;
        align-items: center;
        gap: 15px;
        margin-bottom: 20px;
    }

    .detail-product-quantity input {
        width: 50px;
        text-align: center;
        padding-top: 5px;
        font-size: 16px;
        border: 1px solid #aaa;
        border-radius: 4px;
    }

    .detail-product-btn {
        width: 30px;
        height: 30px;
        font-size: 20px;
        border: 1px solid #aaa;
        background: #eee;
        border-radius: 4px;
        cursor: pointer;
        transition: 0.15s;
    }

    .detail-product-btn:hover {
        background: #d6d6d6;
    }

    .detail-product-add-cart {
        margin-bottom: 15px;
        background: #3b5c2f;
        color: #fff;
        border: none;
        padding: 10px 20px;
        font-size: 15px;
        border-radius: 5px;
        cursor: pointer;
    }

    .detail-product-add-cart:hover {
        background-color: #2d471f;
    }

    .detail-product-action-row {
        display: flex;
        align-items: center;
        gap: 20px; /* khoảng cách giữa số lượng và nút giỏ */
        margin-bottom: 20px;
    }

    .detail-product-policy {
        list-style: none;
        margin-left: -34px;
    }

    .detail-product-policy img {
        width: 6%;
    }

    .detail-product-policy li {
        margin-bottom: 8px;
        display: flex;
    }

    .detail-product-policy li p{
        margin-top: 10px;
        margin-left: 10px;
    }

    /* ===== Mô tả chi tiết ===== */
    .detail-product-description {
        max-width: 1300px;
        margin: 40px auto;
        padding: 0 40px;
    }

    .detail-product-section-title {
        font-size: 22px;
        font-weight: 600;
        margin-bottom: 10px;
        position: relative;
        padding-bottom: 6px;
    }

    .detail-product-section-title::after {
        content: "";
        position: absolute;
        left: 0;
        bottom: 0;
        width: 1250px;
        height: 3px;
        background-color: #839b4c;
    }

    .detail-product-subtitle {
        color: #c76d00;
        margin-top: 20px;
        margin-bottom: 8px;
    }

    .detail-product-list {
        margin-left: 20px;
        margin-bottom: 15px;
    }

    .detail-product-text {
        margin-bottom: 10px;
    }

    @media (max-width: 768px) {
        .detail-product-page {
            flex-direction: column;
            align-items: center;
        }
        .detail-product-gallery,
        .detail-product-info {
            max-width: 100%;
        }
    }

</style>


<body>

<!-- Thanh thông tin trên cùng -->
<div class="top-info-bar">
    <div class="header-container">
        <span>Ngũ cốc Ngon xin chào!</span>
        <div class="contact-info">
            <a href="mailto:ngucocNgon2025@gmail.com">Email: ngucocNgon2025@gmail.com</a>
            <a href="tel:0357250466">Hotline: 0357 250 466</a>
        </div>
    </div>
</div>


<!-- Header chính -->
<header class="main-header">
    <div class="header-container">
        <!-- Logo -->
        <div class="logo">
            <a href="TrangChu.html">
                <img src="image/Header/logongucocNgon.png" alt="Ngũ cốc Ngon"><img/>
            </a>
        </div>

        <!-- Thanh tìm kiếm -->
        <div class="search-bar">
            <input type="text" placeholder="Tìm kiếm sản phẩm..." aria-label="Tìm kiếm">
            <button type="submit">
                <a href="TimKiem.html">
                    <i class="icon_timkiem">
                        <img src="image/Header/icon_timkiem.png" alt="Tìm kiếm"/>
                    </i>
                </a>
            </button>
        </div>

        <!-- Menu điều hướng -->
        <nav class="main-nav">
            <ul>
                <li><a href="TrangChu.html">Trang chủ</a></li>
                <li><a href="VeNgon.html">Về Ngon</a></li>
                <li class="menu-sp">
                    <a href="SanPham-TatCa.html">Sản phẩm <span class="arrow">▾</span></a>

                    <ul class="dropdown-menu">
                        <li class="dropdown-item">
                            <a href="SanPham-NguCoc.html">Ngũ cốc</a>
                        </li>
                        <li class="dropdown-item">
                            <a href="SanPham-HatDinhDuong.html">Hạt dinh dưỡng</a>
                        </li>
                        <li class="dropdown-item">
                            <a href="SanPham-BanhDinhDuong.html">Bánh dinh dưỡng</a>
                        </li>
                        <li class="dropdown-item">
                            <a href="SanPham-TraGaoLut.html">Trà gạo lứt</a>
                        </li>
                    </ul>

                </li>


                <li><a href="TinTuc1.html">Tin tức</a></li>
                <li><a href="CongTacVien.html">Cộng tác viên</a></li>
                <li><a href="LienHe.html">Liên hệ</a></li>
            </ul>
        </nav>



        <!-- Biểu tượng tài khoản và giỏ hàng -->
        <div class="user-actions">
            <a href="#" class="account-btn" aria-label="Tài khoản">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M12 11C14.2091 11 16 9.20914 16 7C16 4.79086 14.2091 3 12 3C9.79086 3 8 4.79086 8 7C8 9.20914 9.79086 11 12 11ZM12 13C8.68629 13 4 14.5714 4 17V19H20V17C20 14.5714 15.3137 13 12 13Z" fill="#333"/>
                </svg>
            </a>
            <a href="#" class="cart-btn" aria-label="Giỏ hàng">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <circle cx="9" cy="21" r="1"></circle>
                    <circle cx="20" cy="21" r="1"></circle>
                    <path d="M1 1h4l2.68 13.39a1 1 0 0 0 .99.81h9.66a1 1 0 0 0 .98-.8l1.7-8.2H6"></path>
                </svg>
            </a>
        </div>
    </div>

</header>


<!-- Modal cho Giỏ hàng -->
<div id="cart-modal" class="modal">
    <div class="modal-content">
        <span class="close-btn">&times;</span>
        <h2>Giỏ Hàng</h2>
        <p>Hiện chưa có sản phẩm</p>

        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
            <circle cx="9" cy="21" r="1"></circle>
            <circle cx="20" cy="21" r="1"></circle>
            <path d="M1 1h4l2.68 13.39a1 1 0 0 0 .99.81h9.66a1 1 0 0 0 .98-.8l1.7-8.2H6"></path>
        </svg>

        <p>Tổng tiền: 0đ</p>
        <div class="modal-buttons">
            <button class="view-cart-btn" onclick="window.location.href='GioHang.jsp'">Xem Giỏ Hàng</button>
            <button class="checkout-btn" onclick="window.location.href='ThongTinGiaoHang.html'">Thanh Toán</button>
        </div>
    </div>
</div>

<!-- Modal cho Đăng nhập Tài khoản -->
<div id="account-modal" class="modal">
    <div class="modal-content">
        <span class="close-btn">&times;</span>
        <h2>Đăng Nhập Tài Khoản</h2>
        <p>Nhập email và mật khẩu của bạn:</p>
        <form>
            <input type="email" placeholder="Email" required>
            <input type="password" placeholder="Mật khẩu" required>
            <p>This site is protected by reCAPTCHA and the Google <a href="https://policies.google.com/privacy">Privacy Policy</a> and <a href="https://policies.google.com/terms">Terms of Service</a> apply.</p>
            <button type="submit">Đăng Nhập</button>
            <p><a href="#">Khách hàng mới? Tạo tài khoản</a></p>
            <p><a href="#">Quên mật khẩu? Khôi phục mật khẩu</a></p>
        </form>
    </div>
</div>

<!------------------------------------------------------------------------------------>
<!--Body-->

<main class="main-detailProduct">
    <!-- Breadcrumb -->
    <section class="breadcrumb-bar py-2">
        <div class="container">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb mb-0 p-2 rounded-3">
                    <li class="breadcrumb-item"><a href="TrangChu.html">Trang chủ</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Ngũ cốc trẻ em</li>
                </ol>
            </nav>
        </div>
    </section>

    <!-- Detail product -->
    <section class="detail-product-page">

        <!-- Hình ảnh sản phẩm -->
        <div class="detail-product-gallery">
            <img id="detail-product-image" src="${product.imageURL}" alt="Ngũ cốc trẻ em" class="detail-product-image">
        </div>

        <!-- Thông tin sản phẩm -->
        <div class="detail-product-info">
            <h1 class="detail-product-title">${product.productName}</h1>
            <p class="detail-product-price">${product.price}₫</p>

            <div class="detail-product-action-row">
                <div class="detail-product-quantity">
                    <button id="detail-product-minus" class="detail-product-btn">-</button>
                    <input type="text" id="detail-product-qty" value="1" min="1">
                    <button id="detail-product-plus" class="detail-product-btn">+</button>
                </div>

                <button class="detail-product-add-cart">Thêm vào giỏ</button>
            </div>

            <ul class="detail-product-policy">
                <li>
                    <img src="image/icon-detail-product/cam-ket.png" alt="Cam kết">
                    <p>Cam kết chất lượng sản phẩm 100%</p>
                </li>
                <li>
                    <img src="image/icon-detail-product/kiem-tra.png" alt="Kiểm tra">
                    <p>Kiểm tra hàng hóa khi nhận hàng</p>
                </li>
                <li>
                    <img src="image/icon-detail-product/doi-tra.png" alt="Đổi trả">
                    <p>Đổi trả trong 30 ngày nếu sản phẩm hết hạn</p>
                </li>
            </ul>
        </div>
    </section>

    <!-- Mô tả sản phẩm -->
    <section class="detail-product-description">
        <h2 class="detail-product-section-title">Thông tin bạn cần biết</h2>

        <p class="detail-product-text">
            ${product.productDescription}
        </p>

        <h3 class="detail-product-subtitle">Thành phần:</h3>
        <p class="detail-product-text">
            ${product.ingredient}
        </p>


        <h3 class="detail-product-subtitle">Công dụng:</h3>
            <p>${product.uses}</p>

        <h3 class="detail-product-subtitle">Hướng dẫn sử dụng:</h3>
            <p>${product.instruction}</p>



        <h3 class="detail-product-subtitle">Lưu ý:</h3>
        <p class="detail-product-text">${product.attention}</p>

        <h3 class="detail-product-subtitle">Hạn sử dụng:</h3>
            <p>${product.productExpiryDate}</p>

    </section>

</main>

<!------------------------------------------------------------------------------>
<!--Footer-->

<div class="main-footer-new">
    <!--section đăng kí nhận tin-->
    <section id="send-for-gmail" class="section section-for-email">
        <!--phần tử sẽ chiếm toàn bộ chiều ngang màn hình-->
        <div class="container-fluid">
            <div class="row flexAlignCenter flexJustiCenter">
                <div class="col-md-6 col-sm-12">
                    <h3 class="title">Đăng kí nhận tin</h3>
                    <p class="content">
                        Đăng ký Email để theo dõi những sản phẩm được giảm giá của chúng tôi.
                        <br>
                        Theo dõi fanpage Ngũ cốc Ngon để cập nhật thông tin mới nhất.
                    </p>
                </div>

                <div class="col-md-6 col-sm-12">
                    <div class="form-newsletter">
                        <form accept-charset="UTF-8" action="/account/contact" class="contact-form" method="post">
                            <input name="form_type" type="hidden" value="customer">
                            <input name="utf8" type="hidden" value="✓">
                            <div class="form-group">
                                <input type="hidden" id="newsletter_tags" name="contact[tags]"
                                       value="khách hàng tiềm năng, bản tin">
                                <input required="" type="email" value="" placeholder="Nhập email của bạn"
                                       name="contact[email]" aria-label="Email Address"
                                       class="inputNew form-control grey newsletter-input">
                                <button type="submit" class="button dark submitNewsletter"><span>Gửi</span></button>
                            </div>
                            <div class="sitebox-recaptcha hidden">
                                This site is protected by reCAPTCHA and the Google
                                <a href="https://policies.google.com/privacy" target="_blank"
                                   rel="noreferrer">Privacy Policy</a>
                                and <a href="https://policies.google.com/terms" target="_blank"
                                       rel="noreferrer">Terms of Service</a> apply.
                            </div>
                        </form>
                    </div>
                </div>


            </div>

        </div>
    </section>


    <!-- Footer chính -->
    <footer class="main-footer footer">
        <div class="footer-middle">
            <div class="container-fluid">
                <div class="footer-middle-container">



                    <div class="row">
                        <!-- Cột 1: Giới thiệu -->
                        <div class="footer-about ft-col col-md-3 col-sm-6 col-xs-12">
                            <div class="logo-footer">

                                <a href="TrangChu.html" title="Ngũ cốc Ngon" aria-label="logo shop footer">
                                    <img src="image/Header/logongucocNgon.png" height="100px" width="250px"
                                         alt="Ngũ cốc Ngon">
                                </a>
                            </div>
                            <p>Công ty TNHH Phát triển Nông nghiệp Xanh Ngon<br>
                                ĐC: Dĩ An, TP.HCM<br>
                                ĐT: 0357250466<br>
                                Email: ngucocNgon@gmail.com<br>
                                Giấy CNĐKKD: 34472346746(23/2/2025)</p>
                            <div class="logo-footer-bct">

                                <img src="https://theme.hstatic.net/200000759239/1001104497/14/logo_bct.png?v=330"
                                     height="70px" width="150px" alt="Bộ Công Thương">

                            </div>
                        </div>

                        <!-- Cột 2: Hỗ trợ khách hàng -->
                        <div class="boxlink ft-col col-md-3 col-sm-6 col-xs-12">
                            <h3 class="footer-title">HỖ TRỢ KHÁCH HÀNG</h3>
                            <ul>
                                <li><a href="TimKiem.html" title="Tìm kiếm">Tìm kiếm</a></li>
                                <li><a href="ChinhSachDoiTra.html" title="Chính sách đổi trả">Chính sách đổi
                                    trả</a></li>
                                <li><a href="ChinhSachBaoMat.html" title="Chính sách bảo mật">Chính sách bảo
                                    mật</a></li>
                                <li><a href="DieuKhoanDichVu.html" title="Điều khoản dịch vụ">Điều khoản dịch
                                    vụ</a></li>
                                <li><a href="ChinhSachThanhToan.html"
                                       title="Phương thức thanh toán">Phương thức thanh toán</a></li>
                            </ul>
                        </div>

                        <!-- Cột 3: Kết nối nhanh -->
                        <div class="boxlink ft-col col-md-3 col-sm-6 col-xs-12">
                            <h3 class="footer-title">KẾT NỐI NHANH</h3>
                            <ul>
                                <li><a href="TrangChu.html" title="Trang chủ">Trang chủ</a></li>
                                <li><a href="VeNgon.html" title="Ngon">Ngon</a></li>
                                <li><a href="SanPham-TatCa.html" title="Sản phẩm">Sản phẩm</a></li>
                                <li><a href="TinTuc1.html" title="Tin tức">Tin tức</a></li>
                                <li><a href="CongTacVien.html" title="Cộng tác viên">Cộng tác viên</a></li>
                                <li><a href="LienHe.html" title="Liên hệ">Liên hệ</a></li>
                            </ul>
                        </div>

                        <!-- Cột 4: Liên hệ và mạng xã hội -->
                        <div class="boxphone ft-col col-md-3 col-sm-6 col-xs-12">
                            <h3 class="footer-title">CHĂM SÓC KHÁCH HÀNG</h3>
                            <p class="fter-hotline">
                                <a href="tel:0357250466" rel="nofollow">0357 250 466</a>
                            </p>
                            <h3 class="footer-title">THEO DÕI CHÚNG TÔI</h3>
                            <ul class="shop_social">
                                <li class="facebook_social">
                                    <a href="#" target="_blank" rel="noreferrer" title="Facebook"
                                       aria-label="Facebook">
                                        <i class="fa fa-facebook"></i>
                                    </a>
                                </li>
                                <li class="instagram_social">
                                    <a href="#" target="_blank" rel="noreferrer" title="Instagram"
                                       aria-label="Instagram">
                                        <i class="fa fa-instagram"></i>
                                    </a>
                                </li>
                                <li class="youtube_social">
                                    <a href="#" target="_blank" rel="noreferrer" title="Youtube"
                                       aria-label="Youtube">
                                        <i class="fa fa-youtube-play"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--back to top bootstrap-->
        <button onclick="window.scrollTo({ top: 0, behavior: 'smooth' });"
                id="btn-back-to-top"
                class="btn btn-success btn-lg">
            ↑
        </button>

        <div class="footer-copyright text-center">
            <div class="container-fluid">
                <p>Copyright © 2025 <a href="TrangChu.html">Ngũ cốc Ngon</a>. Powered by <a href="#" target="_blank"
                                                                                            rel="noreferrer">Team 18</a></p>
            </div>
        </div>
    </footer>
</div>

<!-- Tăng giảm số lượng js -->
<script>
    document.addEventListener('DOMContentLoaded', () => {
        const qtyInput = document.getElementById('detail-product-qty');
        document.getElementById('detail-product-plus').onclick = () => {
            qtyInput.value = Number(qtyInput.value) + 1;
        };
        document.getElementById('detail-product-minus').onclick = () => {
            if (qtyInput.value > 1) qtyInput.value = Number(qtyInput.value) - 1;
        };

    });

</script>

<!--back to top (bootstrap) js-->
<script>
    const backToTopBtn = document.getElementById("btn-back-to-top");

    window.addEventListener("scroll", function() {
        if (window.scrollY > 300) {
            backToTopBtn.style.display = "block";
        } else {
            backToTopBtn.style.display = "none";
        }
    });
</script>

</body>
</html>