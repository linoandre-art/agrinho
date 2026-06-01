document.addEventListener('DOMContentLoaded', () => {
    
    // --- 1. Alternador de Tema (Claro / Noturno Verde) ---
    const themeToggleBtn = document.getElementById('theme-toggle');
    const currentTheme = localStorage.getItem('theme');

    if (currentTheme) {
        document.documentElement.setAttribute('data-theme', currentTheme);
        if (currentTheme === 'dark') {
            themeToggleBtn.textContent = '☀️ Modo Claro';
        }
    }

    themeToggleBtn.addEventListener('click', () => {
        let theme = document.documentElement.getAttribute('data-theme');
        
        if (theme === 'dark') {
            document.documentElement.setAttribute('data-theme', 'light');
            localStorage.setItem('theme', 'light');
            themeToggleBtn.textContent = '🌱 Mudar Tom';
        } else {
            document.documentElement.setAttribute('data-theme', 'dark');
            localStorage.setItem('theme', 'dark');
            themeToggleBtn.textContent = '☀️ Modo Claro';
        }
    });

    // --- 2. Envio de Ideias do Formulário ---
    const contactForm = document.getElementById('contact-form');
    const formResponse = document.getElementById('form-response');

    contactForm.addEventListener('submit', (event) => {
        event.preventDefault(); 

        const name = document.getElementById('name').value.trim();

        if (name) {
            formResponse.textContent = `Parabéns, ${name}! Sua sugestão sustentável foi enviada com sucesso para a comissão do Agrinho 2026.`;
            formResponse.className = "success"; 
            formResponse.classList.remove('hidden');

            contactForm.reset();

            // Oculta o aviso de sucesso após 6 segundos
            setTimeout(() => {
                formResponse.classList.add('hidden');
            }, 6000);
        }
    });
});
