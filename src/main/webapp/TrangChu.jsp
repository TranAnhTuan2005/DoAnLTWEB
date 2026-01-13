<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <title>Ngũ cốc Ngon | Dinh dưỡng cho mọi nhà</title>

    <link rel="stylesheet" href="style.css">
    <script src="script.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

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
            <a href="<c:url value='/TrangChu'/>">
                <img src="image/Header/logongucocNgon.png" alt="Ngũ cốc Ngon"><img/>
            </a>
        </div>

        <!-- Thanh tìm kiếm -->
        <div class="search-bar">
            <input type="text" placeholder="Tìm kiếm sản phẩm..." aria-label="Tìm kiếm">
            <button type="submit">
                <a href="TimKiem.jsp">
                    <i class="icon_timkiem">
                        <img src="image/Header/icon_timkiem.png" alt="Tìm kiếm"/>
                    </i>
                </a>
            </button>
        </div>

        <!-- Menu điều hướng -->
        <nav class="main-nav">
            <ul>
                <li><a href="<c:url value='/TrangChu'/>">Trang chủ</a></li>
                <li><a href="<c:url value='/VeNgon'/>">Về Ngon</a></li>
                <li class="menu-sp">
                    <a href="${pageContext.request.contextPath}/SanPham-TatCa">Sản phẩm <span class="arrow">▾</span></a>

                    <ul class="dropdown-menu">
                        <li class="dropdown-item">
                            <a href="SanPham-NguCoc.jsp">Ngũ cốc</a>
                        </li>
                        <li class="dropdown-item">
                            <a href="SanPham-HatDinhDuong.jsp">Hạt dinh dưỡng</a>
                        </li>
                        <li class="dropdown-item">
                            <a href="SanPham-BanhDinhDuong.jsp">Bánh dinh dưỡng</a>
                        </li>
                        <li class="dropdown-item">
                            <a href="SanPham-TraGaoLut.jsp">Trà gạo lứt</a>
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

            <c:choose>

                <c:when test="${not empty sessionScope.user}">
                    <a href="javascript:void(0)" class="account-btn" aria-label="Tài khoản">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                             xmlns="http://www.w3.org/2000/svg">
                            <path d="M12 11C14.2091 11 16 9.20914 16 7
                             C16 4.79086 14.2091 3 12 3
                             C9.79086 3 8 4.79086 8 7
                             C8 9.20914 9.79086 11 12 11ZM12 13
                             C8.68629 13 4 14.5714 4 17V19H20V17
                             C20 14.5714 15.3137 13 12 13Z"
                                  fill="#333"/>
                        </svg>
                    </a>

                    <div id="accountMenu" class="account-menu">
                        <div class="account-menu_arrow"></div>
                        <div class="account-menu_inner">
                            <p class="account-menu_hello">
                                Xin chào, <strong>${sessionScope.user.fullName}</strong>
                            </p>
                            <hr>
                            <a href="#" class="account-menu_link">Thông tin tài khoản</a>
                            <a href="<c:url value='/DangXuat'/>" class="account-menu_link">Đăng xuất</a>
                        </div>
                    </div>
                </c:when>


                <c:otherwise>
                    <a href="<c:url value='/DangNhapTaiKhoan'/>"
                       class="account-btn" aria-label="Tài khoản">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                             xmlns="http://www.w3.org/2000/svg">
                            <path d="M12 11C14.2091 11 16 9.20914 16 7
                             C16 4.79086 14.2091 3 12 3
                             C9.79086 3 8 4.79086 8 7
                             C8 9.20914 9.79086 11 12 11ZM12 13
                             C8.68629 13 4 14.5714 4 17V19H20V17
                             C20 14.5714 15.3137 13 12 13Z"
                                  fill="#333"/>
                        </svg>
                    </a>
                </c:otherwise>

            </c:choose>

            <!-- CART -->
            <a href="<c:url value='/GioHang'/>" class="cart-btn" aria-label="Giỏ hàng">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                     viewBox="0 0 24 24" fill="none"
                     stroke="black" stroke-width="2"
                     stroke-linecap="round" stroke-linejoin="round">
                    <circle cx="9" cy="21" r="1"></circle>
                    <circle cx="20" cy="21" r="1"></circle>
                    <path d="M1 1h4l2.68 13.39a1 1 0 0 0 .99.81h9.66
                     a1 1 0 0 0 .98-.8l1.7-8.2H6"></path>
                </svg>
            </a>

        </div>

    </div>

</header>



<!------------------------------------------------------------------------------>
<section class="home-slider"> <!-- Section trình chiếu ảnh trang chủ -->
    <div class="slider-container">

        <div class="slide active"> <!-- Hình ảnh hiển thị đầu tiên -->
            <img src="image/home-slider/slide1.jpg" alt="Ngũ cốc">
        </div>
        <div class="slide">
            <img src="image/home-slider/slide2.jpg" alt="Ngũ cốc">
        </div>
        <div class="slide">
            <img src="image/home-slider/slide3.jpg" alt="Ngũ cốc">
        </div>
        <div class="slide">
            <img src="image/home-slider/slide4.jpg" alt="Ngũ cốc">
        </div>

        <button class="prev-btn">&#10094;</button> <!-- Nút qua ảnh trước -->
        <button class="next-btn">&#10095;</button> <!-- Nút qua ảnh sau -->

        <div class="dots"></div> <!-- Dấu chấm điều hướng -->
    </div>
</section>

<section class="suggest-interest"> <!-- Section có thể bạn quan tâm -->
    <div class="suggest-interest-container">
        <div class="si-heading">
            <div class="si-title">
                <h2>CÓ THỂ BẠN QUAN TÂM</h2>
            </div>
        </div>
        <div class="si-items">
            <a href="SanPham-TatCa.jsp" class="si-item">
                <div class="si-img">
                    <img src="image/suggest-interest/ngu_coc_me_bau.png" alt="Ngũ cốc mẹ bầu">
                </div>
                <p>Ngũ cốc mẹ bầu</p>
            </a>

            <a href="SanPham-TatCa.jsp" class="si-item">
                <div class="si-img">
                    <img src="image/suggest-interest/ngu_coc_loi_sua.png" alt="Ngũ cốc lợi sữa">
                </div>
                <p>Ngũ cốc lợi sữa</p>
            </a>

            <a href="SanPham-TatCa.jsp" class="si-item">
                <div class="si-img">
                    <img src="image/suggest-interest/ngu_coc_tre_em.png" alt="Ngũ cốc trẻ em">
                </div>
                <p>Ngũ cốc trẻ em</p>
            </a>

            <a href="SanPham-TatCa.jsp" class="si-item">
                <div class="si-img">
                    <img src="image/suggest-interest/ngu_coc_dinh_duong_cao_cap.png"
                         alt="Ngũ cốc dinh dưỡng cao cấp">
                </div>
                <p>Ngũ cốc dinh dưỡng<br>cao cấp</p>
            </a>

            <a href="SanPham-TatCa.jsp" class="si-item">
                <div class="si-img">
                    <img src="image/suggest-interest/ngu_coc_nguoi_gia.png" alt="Ngũ cốc người già">
                </div>
                <p>Ngũ cốc người già</p>
            </a>

            <a href="SanPham-TatCa.jsp" class="si-item">
                <div class="si-img bg-lightgreen">
                    <img src="image/suggest-interest/ngu_coc_khac.png" alt="Ngũ cốc khác">
                </div>
                <p>Ngũ cốc khác</p>
            </a>
        </div>
    </div>
</section>

<section class="cate-product"> <!-- Section danh mục sản phẩm -->
    <h2 class="section-title">
        <img src="image/categoryProduct/title-icon.png" alt="icon" class="icon"> DANH MỤC SẢN PHẨM
    </h2>

    <div class="product-list">
        <a href="SanPham-TatCa.jsp" class="product-card-a">
            <div class="product-card">
                <img src="image/categoryProduct/ngu_coc.png" alt="Ngũ cốc" class="product-img">
                <h3 class="product-title">Ngũ cốc</h3>
            </div>
        </a>

        <a href="SanPham-TatCa.jsp" class="product-card-a">
            <div class="product-card">
                <img src="image/categoryProduct/combohatsen.jpg" alt="Hạt dinh dưỡng" class="product-img">
                <h3 class="product-title">Hạt dinh dưỡng</h3>
            </div>
        </a>

        <a href="SanPham-TatCa.jsp" class="product-card-a">
            <div class="product-card">
                <img src="image/categoryProduct/banh_dinh_duong.png" alt="Bánh dinh dưỡng" class="product-img">
                <h3 class="product-title">Bánh dinh dưỡng</h3>
            </div>
        </a>

        <a href="SanPham-TatCa.jsp" class="product-card-a">
            <div class="product-card">
                <img src="image/categoryProduct/tra_gao_lut.png" alt="Trà gạo lứt" class="product-img">
                <h3 class="product-title">Trà gạo lứt</h3>
            </div>
        </a>

    </div>

</section>

<!------------------------------------------------------------------------------>
<section class="new-products"> <!-- section hiển thị sản phẩm mới nhất -->

    <div class="products-container"> <!-- chứa các component -->
        <!--Label-->
        <h2>SẢN PHẨM MỚI NHẤT</h2>
        <p class="subtitle">Cập nhật những sản phẩm mới nhất</p>

        <!-- TẤT CẢ SẢN PHẨM CHUNG 1 GRID -->
        <div class="product-grid">

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/banhhat.jpg"
                         alt="Bánh hạt dinh dưỡng cao cấp"><!-- hình ảnh minh họa -->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/banhhat.jpg','Bánh hạt dinh dưỡng 30 x 15g', '219,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Bánh hạt dinh dưỡng 30 x 15g</h3>
                <p class="price">219,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/botgaolut.png"
                         alt="Bột gạo lứt mè đen hỗ trợ giảm cân"><!-- hình ảnh minh họa -->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/botgaolut.png', 'Bột gạo lứt mè đen hỗ trợ giảm cân', '179,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Bột gạo lứt mè đen hỗ trợ giảm cân</h3>
                <p class="price">179,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/botngucoc.png"
                         alt="Bột ngũ cốc tăng cân"><!-- hình ảnh minh họa -->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/botngucoc.png', 'Bột ngũ cốc tăng cân', '209,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Bột ngũ cốc tăng cân</h3>
                <p class="price">209,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/chaohat.png"
                         alt="Cháo hạt vỡ cho trẻ em"><!-- hình ảnh minh họa -->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/chaohat.png','Cháo hạt vỡ cho trẻ em','169,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Cháo hạt vỡ cho trẻ em</h3>
                <p class="price">169,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/combohatsen.jpg"
                         alt="Combo hat sen 100g"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/combohatsen.jpg', 'Combo hạt sen nấu sữa 14 gói 100g', '329,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Combo hạt sen nấu sữa 14 gói 100g</h3>
                <p class="price">329,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/combohatsen50g.jpg"
                         alt="Combo hat sen 50g"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/combohatsen50g.jpg', 'Combo hạt sen nấu sữa 14 gói 50g', '189,000đ')">
                            👁 XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Combo hạt sen nấu sữa 14 gói 50g</h3>
                <p class="price">189,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/granola.png" alt="Granola"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/granola.png','Granola', '179,000đ')">👁 XEM
                            NHANH
                        </button>
                    </div>
                </div>
                <h3>Granola</h3>
                <p class="price">179,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/hanhnhantachvo.jpg"
                         alt="Hạnh nhân tách vỏ"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/hanhnhantachvo.jpg','Hạnh nhân tách vỏ', '195,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Hạnh nhân tách vỏ</h3>
                <p class="price">195,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/hatbixanh.jpg" alt="Hạt bí xanh"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/hatbixanh.jpg', 'Hạt bí xanh', '135,000đ')">👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Hạt bí xanh</h3>
                <p class="price">135,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/hatdieusay.jpg"
                         alt="Hạt điều sấy tự nhiên"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/hatdieusay.jpg', 'Hạt điều sấy tự nhiên', '195,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Hạt điều sấy tự nhiên</h3>
                <p class="price">195,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/mixhat.png" alt="Mix hạt"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/mixhat.png', 'Mix hạt', '239,000đ')">👁 XEM
                            NHANH
                        </button>
                    </div>
                </div>
                <h3>Mix hạt</h3>
                <p class="price">239,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/mixtraicay.png" alt="Mix trái cây"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/mixtraicay.png', 'Mix trái cây', '179,000đ')">👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Mix trái cây</h3>
                <p class="price">179,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/ngucocdd10goi.jpg"
                         alt="Ngũ cốc dinh dưỡng 10 gói"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/ngucocdd10goi.jpg', 'Ngũ cốc dinh dưỡng 10 gói', '239,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Ngũ cốc dinh dưỡng 10 gói</h3>
                <p class="price">239,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/ngucocdd15goi.jpg"
                         alt="Ngũ cốc dinh dưỡng 15 gói"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/ngucocdd15goi.jpg','Ngũ cốc dinh dưỡng 15 gói','159,000đ'  )">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Ngũ cốc dinh dưỡng 15 gói</h3>
                <p class="price">159,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/ngucocddcaocap.jpg"
                         alt="Ngũ cốc dinh dưỡng cao cấp"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/ngucocddcaocap.jpg','Ngũ cốc dinh dưỡng cao cấp', '239,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Ngũ cốc dinh dưỡng cao cấp</h3>
                <p class="price">239,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/ngucocloisua.png" alt="Ngũ cốc lợi sữa"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/ngucocloisua.png', 'Ngũ cốc lợi sữa', '199,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Ngũ cốc lợi sữa</h3>
                <p class="price">199,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/ngucocmebau.png" alt="Ngũ cốc mẹ bầu"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/ngucocmebau.png','Ngũ cốc mẹ bầu','239,000đ' )">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Ngũ cốc mẹ bầu</h3>
                <p class="price">239,000đ</p>
            </div>

            <!-- Sản phẩm -->
            <div class="product-item">
                <div class="product-image">
                    <img src="image/newProducts/ngucocnggia.png"
                         alt="Ngũ cốc cho người lớn tuổi"><!-- Hình ảnh minh họa-->
                    <div class="overlay"><!-- Hover để hiển thị-->
                        <button class="add-to-cart">🛒 THÊM VÀO GIỎ</button>
                        <button class="view-btn"
                                onclick="openModal('./image/newProducts/ngucocnggia.png', 'Ngũ cốc cho người lớn tuổi', '219,000đ')">
                            👁
                            XEM NHANH
                        </button>
                    </div>
                </div>
                <h3>Ngũ cốc cho người lớn tuổi</h3>
                <p class="price">219,000đ</p>
            </div>

        </div>
    </div>
</section>


<!-- Modal hiển thị chi tiết sản phẩm-->
<div class="product-modal" id="productModal">
    <div class="product-modal-content">
        <button class="close-modal" onclick="closeModal()">&times;</button>
        <img id="modal-img" src="" alt="">
        <div class="infor">
            <h3 id="modal-name"></h3>
            <p class="price" id="modal-price"></p>
            <div class="quantity-box">
                <button class="qty-btn" id="qty-decrease">-</button>
                <input type="text" id="product-qty" value="1" min="1">
                <button class="qty-btn" id="qty-increase">+</button>
            </div>
            <button class="add">🛒 THÊM VÀO GIỎ</button>
            <p><a href="ChiTietSanPham.html">Xem chi tiết sản phẩm</a></p>
        </div>
    </div>
</div>

<!------------------------------SẢN PHẨM ĐƯỢC YÊU THÍCH NHẤT-------------------------------------------------->
<section class="favorite-products">
    <div class="favorite-container">
        <h2>SẢN PHẨM ĐƯỢC ƯA THÍCH</h2>
        <p class="subtitle">Luôn luôn tươi, sạch</p>

        <div class="favorite-grid">
            <!-- Cột 1 -->
            <div class="favorite-column">
                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/banhhat.jpg" alt="Bánh hạt"></a>
                    <div class="fav-info">
                        <a href="">Bánh hạt dinh dưỡng 30 x 15 g</a>
                        <p class="price">219,000₫</p>
                    </div>
                </div>

                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/botgaolut.png" alt="Bột gạo lứt"></a>
                    <div class="fav-info">
                        <a href="">Bột gạo lứt mè đen hỗ trợ giảm cân</a>
                        <p class="price">179,000₫</p>
                    </div>
                </div>

                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/botngucoc.png" alt="Bột ngũ cốc"></a>
                    <div class="fav-info">
                        <a href="">Bột ngũ cốc tăng cân</a>
                        <p class="price">209,000₫</p>
                    </div>
                </div>
            </div>

            <!-- Cột 2 -->
            <div class="favorite-column">
                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/chaohat.png" alt="Cháo hạt vỡ"></a>
                    <div class="fav-info">
                        <a href="">Cháo hạt vỡ cho trẻ em</a>
                        <p class="price">169,000₫</p>
                    </div>
                </div>

                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/combohatsen.jpg" alt="Combo 100g"></a>
                    <div class="fav-info">
                        <a href="">Combo set hạt nấu sữa 14 gói 100g</a>
                        <p class="price">329,000₫</p>
                    </div>
                </div>

                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/combohatsen50g.jpg" alt="Combo 50g"></a>
                    <div class="fav-info">
                        <a href="">Combo set hạt nấu sữa 14 gói 50g</a>
                        <p class="price">189,000₫</p>
                    </div>
                </div>
            </div>

            <!-- Cột 3 -->
            <div class="favorite-column">
                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/granola.png" alt="Granola"></a>
                    <div class="fav-info">
                        <a href="">Granola</a>
                        <p class="price">179,000₫</p>
                    </div>
                </div>

                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/hatdieusay.jpg" alt="Hạt điều sấy"></a>
                    <div class="fav-info">
                        <a href="">Hạt điều sấy tự nhiên</a>
                        <p class="price">195,000₫</p>
                    </div>
                </div>

                <div class="fav-item">
                    <a href=""><img src="image/favouriteProduct/mixhat.png" alt="Mix hạt"></a>
                    <div class="fav-info">
                        <a href="">Mix hạt</a>
                        <p class="price">239,000₫</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<!------------------------------TIN TỨC-------------------------------------------------->
<section class="news-section">
    <div class="container"></div>
    <h2>TIN TỨC</h2>
    <p class="subtitle">Cập nhật những bài viết hữu ích dành cho khách hàng</p>
    <div class="news-grid">

        <div class="news-item">
            <div class="news-img">
                <img src="image/news/tin-tuc-cacloaihat.png" alt="Tin tức chính về các loại">
            </div>
            <a href="" class="title">
                <h3>+5 LOẠI HẠT DINH DƯỠNG CẦN THIẾT CHO MẸ BẦU</h3>
            </a>
            <p class="sub-paragraph">Bài viết này chúng tôi sẽ bật mí 5 loại hạt siêu dinh dưỡng không thể thiếu
                trong thực đơn...</p>
            <a href="#" class="more">Xem thêm</a>
        </div>

        <div class="news-item">
            <div class="news-img">
                <img src="image/news/tin-tuc-ncdd.webp" alt="Tin tức chính về các loại">
            </div>
            <a href="" class="title">
                <h3>NGŨ CỐC CAO CẤP CÓ THỰC SỰ HỖ TRỢ NGƯỜI ỐM PHỤC HỒI NHANH</h3>
            </a>
            <p class="sub-paragraph">Sau một đợt ốm kéo dài, cơ thể chúng ta cần một chế độ dinh dưỡng đặc biêt để
                hồi...</p>
            <a href="#" class="more">Xem thêm</a>
        </div>

        <div class="news-item">
            <div class="news-img">
                <img src="image/news/tao-do.jpg" alt="Tin tức chính về các loại">
            </div>
            <a href="" class="title">
                <h3>TÁO ĐỎ TÂN CƯƠNG CHẤT LƯỢNG, GIÁ TỐT TẠI HUẾ</h3>
            </a>
            <p class="sub-paragraph">Táo đỏ Tân Cương, một trong những đặc sản nổi tiếng của vùng đất này(Trung
                Quốc), được nhiều người...</p>
            <a href="#" class="more">Xem thêm</a>
        </div>
    </div>
</section>


<!------------------------------------------------------------------------------>
<!--Footer-->

<div class="main-footer-new">
    <!--section đăng kí nhận tin-->
    <section id="send-for-gmail" class="section section-for-email">

        <!--phần tử sẽ chiếm toàn bộ chiều ngang màn hình-->
        <!--thẻ div gồm các class sử dụng bootstrap chia 4 cột-->
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
                                <a href="TrangChu-daDNTK.html" title="Ngũ cốc Ngon" aria-label="logo shop footer">
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
                                <li><a href="TimKiem.jsp" title="Tìm kiếm">Tìm kiếm</a></li>
                                <li><a href="ChinhSachDoiTra.html" title="Chính sách đổi trả">Chính sách đổi
                                    trả</a></li>
                                <li><a href="ChinhSachBaoMat.html" title="Chính sách bảo mật">Chính sách bảo
                                    mật</a></li>
                                <li><a href="DieuKhoanDichVu.html" title="Điều khoản dịch vụ">Điều khoản dịch
                                    vụ</a></li>
                                <li><a href="PhuongThucThanhToan.jsp"
                                       title="Phương thức thanh toán">Phương thức thanh toán</a></li>

                            </ul>
                        </div>

                        <!-- Cột 3: Kết nối nhanh -->
                        <div class="boxlink ft-col col-md-3 col-sm-6 col-xs-12">
                            <h3 class="footer-title">KẾT NỐI NHANH</h3>
                            <ul>
                                <li><a href="TrangChu-daDNTK.html" title="Trang chủ">Trang chủ</a></li>
                                <li><a href="VeNgon.jsp" title="Ngon">Ngon</a></li>
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

<!--back to top (bootstrap) js-->
<script>
    const backToTopBtn = document.getElementById("btn-back-to-top");

    window.addEventListener("scroll", function () {
        if (window.scrollY > 300) {
            backToTopBtn.style.display = "block";
        } else {
            backToTopBtn.style.display = "none";
        }
    });
</script>


<script>
    document.addEventListener('DOMContentLoaded', () => {
        const accountBtn = document.querySelector('.account-btn');
        const accountMenu = document.getElementById('accountMenu');

        if (!accountBtn || !accountMenu) return;

        // Click icon → toggle dropdown
        accountBtn.addEventListener('click', (e) => {
            e.preventDefault();
            e.stopPropagation();
            accountMenu.classList.toggle('show');
        });

        // Click ra ngoài → đóng
        document.addEventListener('click', (e) => {
            if (
                accountMenu.classList.contains('show') &&
                !accountMenu.contains(e.target) &&
                !accountBtn.contains(e.target)
            ) {
                accountMenu.classList.remove('show');
            }
        });
    });

</script>





</body>
</html>