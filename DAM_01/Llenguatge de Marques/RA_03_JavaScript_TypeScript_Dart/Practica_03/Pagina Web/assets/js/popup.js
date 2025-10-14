// Referències als elements
const popup = document.getElementById('popup');
const countdownElement = document.getElementById('countdown');
const closePopup = document.getElementById('closePopup');
const newsletterForm = document.getElementById('newsletterForm');

let countdownTime = 30; // Temps en segons

// Funció per actualitzar la compte enrere
function updateCountdown() {
    const minutes = String(Math.floor(countdownTime / 60)).padStart(2, '0');
    const seconds = String(countdownTime % 60).padStart(2, '0');
    countdownElement.textContent = `${minutes}:${seconds}`;
    countdownTime--;

    if (countdownTime < 0) {
        clearInterval(countdownInterval);
        closePopupOverlay();
    }
}

// Mostrar el popup automàticament
function showPopup() {
    popup.classList.add('active');
    countdownInterval = setInterval(updateCountdown, 1000);
}

// Amagar el popup
function closePopupOverlay() {
    popup.classList.remove('active');
    clearInterval(countdownInterval);
}

// Gestionar el formulari
newsletterForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const email = document.getElementById('email').value;
    if (email) {
        alert(`Gràcies per registrar-te amb el correu: ${email}`);
        closePopupOverlay();
    }
});

// Tancar el popup manualment
closePopup.addEventListener('click', closePopupOverlay);

// Mostrar el popup després de 2 segons de carregar la pàgina
setTimeout(showPopup, 2000);
