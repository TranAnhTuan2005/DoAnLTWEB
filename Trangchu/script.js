
//Add các class, id vào document, tạo biến gọi
document.addEventListener('DOMContentLoaded', () => {
    const cartBtn = document.querySelector('.cart-btn');
    const accountBtn = document.querySelector('.account-btn');
    const cartModal = document.getElementById('cart-modal');
    const accountModal = document.getElementById('account-modal');
    const closeButtons = document.querySelectorAll('.close-btn');

    // Hàm hiển thị dropdown dưới button
    // function showDropdown(modal, button) {
    //     const rect = button.getBoundingClientRect();
    //     modal.style.display = 'block';
    //     modal.style.top = `${rect.bottom + window.scrollY}px`;
    //     // có thể đổi giá trị px để điều chỉnh phần xuất hiện của cửa sổ lùi sang trái
    //    // modal.style.left = `${rect.left + window.scrollX - 300}px`;
    //     modal.style.left = `${rect.left + window.scrollX - (modal.offsetWidth / 2) + (button.offsetWidth / 2)}px`;
    //     modal.style.position = 'absolute';
    // }

    function showDropdown(modal, button) {
        const rect = button.getBoundingClientRect();
        modal.style.display = 'block';
        modal.style.top = `${rect.bottom + window.scrollY}px`;

        // Căn lề
        let left = rect.left + window.scrollX - (modal.offsetWidth / 2) + (button.offsetWidth / 2);

        // Nếu modal tràn ra ngoài bên trái
        if (left < 10) left = 10;

        // Nếu modal tràn ra ngoài bên phải
        const maxRight = window.innerWidth - modal.offsetWidth - 10;
        if (left > maxRight) left = maxRight;

        modal.style.left = `${left}px`;
        modal.style.position = 'absolute';
    }



    // Hiển thị dropdown giỏ hàng
    cartBtn.addEventListener('click', (e) => {
        e.preventDefault();
        e.stopPropagation();
        // Đóng modal tài khoản trước khi mở giỏ hàng
        accountModal.style.display = 'none';
        showDropdown(cartModal, cartBtn);
    });

    // Hiển thị dropdown tài khoản
    accountBtn.addEventListener('click', (e) => {
        e.preventDefault();
        e.stopPropagation();
        // Đóng modal giỏ hàng trước khi mở tài khoản
        cartModal.style.display = 'none';
        showDropdown(accountModal, accountBtn);
    });

    // Đóng dropdown
    closeButtons.forEach(button => {
        button.addEventListener('click', () => {
            cartModal.style.display = 'none';
            accountModal.style.display = 'none';
        });
    });

    // Đóng modal khi click ngoài vùng
    window.addEventListener('click', (event) => {
        if (!cartModal.contains(event.target) && !cartBtn.contains(event.target)) {
            cartModal.style.display = 'none';
        }
        if (!accountModal.contains(event.target) && !accountBtn.contains(event.target)) {
            accountModal.style.display = 'none';
        }
    });
});

/////////////////////////////////////////////////////////////
// Trình chiếu ảnh
document.addEventListener("DOMContentLoaded", function () {
    const slides = document.querySelectorAll(".slide");
    const dotsContainer = document.querySelector(".dots");
    let current = 0;

    // Tạo dấu chấm tương ứng với từng slide
    slides.forEach((_, index) => {
        const dot = document.createElement("span");
        dot.addEventListener("click", () => showSlide(index));
        dotsContainer.appendChild(dot);
    });

    const dots = document.querySelectorAll(".dots span");

    // Hiển thị slide theo index
    function showSlide(index) {
        slides[current].classList.remove("active");
        dots[current].classList.remove("active");

        current = (index + slides.length) % slides.length;

        slides[current].classList.add("active");
        dots[current].classList.add("active");
    }

    // Sự kiện click cho nút điều hướng
    document.querySelector(".next-btn").addEventListener("click", () => showSlide(current + 1));
    document.querySelector(".prev-btn").addEventListener("click", () => showSlide(current - 1));

    // Khởi tạo slide đầu tiên
    showSlide(0);
});

/////////////////////////////////////////////////////////////