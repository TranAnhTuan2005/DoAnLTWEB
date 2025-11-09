//Add các class, id vào document, tạo biến gọi
document.addEventListener('DOMContentLoaded', () => {
    const cartBtn = document.querySelector('.cart-btn');
    const accountBtn = document.querySelector('.account-btn');
    const cartModal = document.getElementById('cart-modal');
    const accountModal = document.getElementById('account-modal');
    const closeButtons = document.querySelectorAll('.close-btn');

    // Hàm toggle modal (mở nếu đóng, đóng nếu mở)
    function toggleModal(modal, otherModal, button) {

        const isCartOpen = cartModal.classList.contains('show');
        const isAccountOpen = accountModal.classList.contains('show');
        // Nếu modal hiện tại đang mở → đóng nó
        if (modal.classList.contains('show')) {
            modal.classList.remove('show');
            return;
        }

        // Đóng modal kia trước
        otherModal.classList.remove('show');

        // Mở modal hiện tại
        modal.classList.add('show');

        // Căn vị trí: dưới nút, căn phải
        const rect = button.getBoundingClientRect();
        modal.style.top = `${rect.bottom + window.scrollY + 5}px`;
        modal.style.right = `${window.innerWidth - rect.right}px`;
        modal.style.left = 'auto';

    }

    // Click nút Giỏ hàng
    cartBtn.addEventListener('click', (e) => {
        e.preventDefault();
        e.stopPropagation();
        toggleModal(cartModal, accountModal, cartBtn);
    });

    // Click nút Tài khoản
    accountBtn.addEventListener('click', (e) => {
        e.preventDefault();
        e.stopPropagation();
        toggleModal(accountModal, cartModal, accountBtn);
    });

    // Đóng khi click nút X
    closeButtons.forEach(btn => {
        btn.addEventListener('click', (e) => {
            e.stopPropagation();
            cartModal.classList.remove('show');
            accountModal.classList.remove('show');
        });
    });

    // Đóng khi click ngoài
    window.addEventListener('click', () => {
        cartModal.classList.remove('show');
        accountModal.classList.remove('show');
    });

    // Ngăn đóng khi click vào modal
    [cartModal, accountModal].forEach(modal => {
        modal.addEventListener('click', (e) => {
            e.stopPropagation();
        });
    });
});


/////////////////////////////////////////////////////////////
// Trình chiếu ảnh
document.addEventListener("DOMContentLoaded", function () {
    const slides = document.querySelectorAll(".slide");
    const dotsContainer = document.querySelector(".dots");
    let current = 0;

    // Tạo ul
    const ul = document.createElement('ul');
    ul.classList.add('slick-dots');
    dotsContainer.appendChild(ul);

    // Tạo <li> cho từng slide
    slides.forEach((_, index) => {
        const li = document.createElement('li');
        li.setAttribute('role', 'presentation');
        li.addEventListener('click', () => showSlide(index));
        ul.appendChild(li);
    });

    const dots = ul.querySelectorAll('li');

    // Hiển thị slide theo index
    function showSlide(index) {
        slides[current].classList.remove('active');
        dots[current].classList.remove('slick-active');

        current = (index + slides.length) % slides.length;

        slides[current].classList.add('active');
        dots[current].classList.add('slick-active');
    }

    // Sự kiện click cho nút điều hướng
    document.querySelector(".next-btn").addEventListener("click", () => showSlide(current + 1));
    document.querySelector(".prev-btn").addEventListener("click", () => showSlide(current - 1));

    // Khởi tạo slide đầu tiên
    showSlide(0);
});

/*Modal chi tiết sản phẩm*/

/*gọi các thẻ trong chi tiết sản phẩm ra để gán giá trị đầu vào cho nó*/
function openModal(imgSrc, name, price) {
    document.getElementById('modal-img').src = imgSrc;
    document.getElementById('modal-name').innerText = name;
    document.getElementById('modal-price').innerText = price;
    document.getElementById('productModal').style.display = 'flex';
}
/*đóng thông tin chi tiết*/
function closeModal() {
    document.getElementById('productModal').style.display = 'none';
}
window.onclick = function (e) {
    const modal = document.getElementById('productModal');
    if (e.target === modal) closeModal();
}

/////////////////////////////////////////////////////////////


