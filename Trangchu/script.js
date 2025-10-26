

document.addEventListener('DOMContentLoaded', () => {
    const cartBtn = document.querySelector('.cart-btn');
    const accountBtn = document.querySelector('.account-btn');
    const cartModal = document.getElementById('cart-modal');
    const accountModal = document.getElementById('account-modal');
    const closeButtons = document.querySelectorAll('.close-btn');

    // Hàm hiển thị dropdown dưới button
    function showDropdown(modal, button) {
        const rect = button.getBoundingClientRect();
        modal.style.display = 'block';
        modal.style.top = `${rect.bottom + window.scrollY}px`;
        modal.style.left = `${rect.left + window.scrollX - 300}px`;
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

    // Đóng khi click ngoài
    window.addEventListener('click', (event) => {
        if (!cartModal.contains(event.target) && !cartBtn.contains(event.target)) {
            cartModal.style.display = 'none';
        }
        if (!accountModal.contains(event.target) && !accountBtn.contains(event.target)) {
            accountModal.style.display = 'none';
        }
    });
});