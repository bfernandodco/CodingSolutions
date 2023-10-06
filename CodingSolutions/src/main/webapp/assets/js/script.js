// Menu 
function menuShow() {
    let menuMobile = document.querySelector('.mobile-menu');
    let icon = document.querySelector('.mobile-menu-icon i');
  
    if (menuMobile.classList.contains('open')) {
      menuMobile.classList.remove('open');
      icon.classList.remove('fa-xmark');
      icon.classList.add('fa-bars');
    } else {
      menuMobile.classList.add('open');
      icon.classList.remove('fa-bars');
      icon.classList.add('fa-xmark');
    }
  }

// Quest Form
document.addEventListener('DOMContentLoaded', function () {
    const sections = document.querySelectorAll('.questions-section');
    let currentSection = 0;
    const totalSections = sections.length;
    const answers = {};

    function showSection(index) {
        sections.forEach((section, i) => {
            if (i === index) {
                section.style.display = 'block';
            } else {
                section.style.display = 'none';
            }
        });
    }

    function goToNextSection() {
        if (currentSection < totalSections - 1) {
            currentSection++;
            showSection(currentSection);
        }
    }

    function goToPreviousSection() {
        if (currentSection > 0) {
            currentSection--;
            showSection(currentSection);
        }
    }

    const form = document.getElementById('dataForm');
    form.addEventListener('submit', function () {
        // Collect answers from the current section
        const currentAnswers = {};
        const currentQuestionInputs = sections[currentSection].querySelectorAll('input[type="radio"]');
        currentQuestionInputs.forEach((input) => {
            currentAnswers[input.name] = input.value;
        });

        // Store the answers for the current section
        answers[`q${currentSection + 1}`] = currentAnswers;

        // Move to the next section or submit the form if last section
        if (currentSection < totalSections - 1) {
            goToNextSection();
        } else {
            // All sections completed, you can submit the answers
            console.log('All answers:', answers);
            // Uncomment the following line to actually submit the form
             form.submit();
            alert('Formulário enviado com sucesso!');
        }
    });

    const nextButton = document.createElement('button');
    nextButton.innerText = 'Próximo';
    nextButton.addEventListener('click', goToNextSection);

    const prevButton = document.createElement('button');
    prevButton.innerText = 'Voltar';
    prevButton.addEventListener('click', goToPreviousSection);

    const submitButton = document.createElement('button');
    submitButton.innerText = 'Submit';
    submitButton.type = 'submit';

    const buttonContainer = document.createElement('div');
    buttonContainer.classList.add('button-container');
    buttonContainer.appendChild(prevButton);
    buttonContainer.appendChild(nextButton);
    buttonContainer.appendChild(submitButton);

    form.appendChild(buttonContainer);

    // Show the first section initially
    showSection(currentSection);
});

// Mask for phone number
$(document).ready(function () {
    $('#phone').inputmask('(99) 99999-9999');
  });