// Aguarda o carregamento total do DOM
document.addEventListener('DOMContentLoaded', () => {
    const themeToggleBtn = document.getElementById('theme-toggle');
    const bodyElement = document.body;

    // Função para alterar o tema
    themeToggleBtn.addEventListener('click', () => {
        // Se estiver no tema escuro, muda para o claro
        if (bodyElement.classList.contains('dark-theme')) {
            bodyElement.classList.remove('dark-theme');
            bodyElement.classList.add('light-theme');
            
            // Altera o ícone para Lua (indicando que o clique seguinte levará ao modo escuro)
            themeToggleBtn.innerHTML = '<i class="fa-solid fa-moon"></i>';
        } else {
            // Se estiver no tema claro, volta para o escuro
            bodyElement.classList.remove('light-theme');
            bodyElement.classList.add('dark-theme');
            
            // Altera o ícone para Sol
            themeToggleBtn.innerHTML = '<i class="fa-solid fa-sun"></i>';
        }
    });

    // Efeito sutil de revelar os elementos ao rolar a página (Scroll Animation básica)
    const cards = document.querySelectorAll('.card');
    
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const cardObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0)';
                observer.unobserve(entry.target);
            }
        });
    }, observerOptions);

    cards.forEach(card => {
        // Configuração inicial oculta para a animação
        card.style.opacity = '0';
        card.style.transform = 'translateY(20px)';
        card.style.transition = 'all 0.6s cubic-bezier(0.4, 0, 0.2, 1)';
        cardObserver.observe(card);
    });
});
