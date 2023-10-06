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
            nextButton.style.display = 'block'; // Mostra o botão "Próximo"
        }
    }

    function goToPreviousSection() {
        if (currentSection > 0) {
            currentSection--;
            showSection(currentSection);
            nextButton.style.display = 'block'; // Mostra o botão "Próximo"
        }
    }

    const form = document.getElementById('dataForm');
    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent form submission

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
            // form.submit();

            // Mostra a mensagem de envio bem-sucedido
            const successMessage = document.createElement('p');
            successMessage.innerText = 'Dados enviados com sucesso!';
            form.appendChild(successMessage);

            // Reseta o formulário após 3 segundos
            setTimeout(() => {
                form.reset();
                currentSection = 0;
                showSection(currentSection);
                successMessage.remove();
            }, 3000);
        }
    });

    const nextButton = document.createElement('button');
    nextButton.innerText = 'Próximo';
    nextButton.classList.add('btn-next'); // Adiciona a classe btn-next
    nextButton.addEventListener('click', () => {
        if (currentSection === totalSections - 1) {
            return; // Impede a ação se for a última seção
        }
        goToNextSection();
    });

    const prevButton = document.createElement('button');
    prevButton.innerText = 'Voltar';
    prevButton.classList.add('btn-prev'); // Adiciona a classe btn-prev
    prevButton.addEventListener('click', goToPreviousSection);

    const submitButton = document.createElement('button');
    submitButton.innerText = 'Enviar';
    submitButton.type = 'submit'; // Alterado para ser o botão de envio

    const buttonContainer = document.createElement('div');
    buttonContainer.classList.add('button-container');
    buttonContainer.appendChild(prevButton);
    buttonContainer.appendChild(nextButton);
    buttonContainer.appendChild(submitButton); // Adiciona o botão de envio

    form.appendChild(buttonContainer);

    // Show the first section initially
    showSection(currentSection);

    // Mostra o botão de enviar e esconde o botão próximo na última pergunta
    if (currentSection === totalSections - 1) {
        nextButton.style.display = 'none';
        buttonContainer.removeChild(nextButton); // Remove o botão "Próximo" se for a última seção
    }
});
