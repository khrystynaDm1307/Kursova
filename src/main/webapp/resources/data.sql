INSERT INTO usr(id, email, first_name, last_name, password, discriminator, balance) VALUES (1, 'test@gmail.com', 'Test', 'User1', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 'user', 1000);
INSERT INTO usr(id, email, first_name, last_name, password, discriminator, balance) VALUES (2, 'test2@gmail.com', 'Test', 'User2', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 'user', 0);
INSERT INTO usr(id, email, first_name, last_name, password, experience, position, telegram_contacts, path_to_photo, discriminator, balance) VALUES (3, 'mentor@gmail.com', 'Таня', 'Пренткович', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 4, 'Founder & Influencer', '@mentor', '/img/tanya.png', 'mentor', 300);
INSERT INTO usr(id, email, first_name, last_name, password, experience, position, telegram_contacts, path_to_photo, discriminator, balance) VALUES (4, 'mentor1@gmail.com', 'Іра', 'Коркушко', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 10, 'Partner & Influencer', '@mentor2', '/img/ira.png', 'mentor', 400);
INSERT INTO usr(id, email, first_name, last_name, password, experience, position, telegram_contacts, path_to_photo, discriminator, balance) VALUES (5, 'mentor2@gmail.com', 'Аня', 'Вітюк', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 3, 'Head of Content Department', '@mentor3', '/img/pr.png', 'mentor', 600);
INSERT INTO usr(id, email, first_name, last_name, password, experience, position, telegram_contacts, path_to_photo, discriminator, balance) VALUES (6, 'mentor3@gmail.com', 'Галя', 'Свентицька', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 7, 'Head of Strategy Department', '@mentor4', '/img/galya.png', 'mentor', 1000);
INSERT INTO usr(id, email, first_name, last_name, password, experience, position, telegram_contacts, path_to_photo, discriminator, balance) VALUES (7, 'mentor4@gmail.com', 'Галя', 'Свентицька', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 7, 'Head of Strategy Department', '@mentor4', '/img/galya.png', 'mentor', 1000);
INSERT INTO usr(id, email, first_name, last_name, password, experience, position, telegram_contacts, path_to_photo, discriminator, balance) VALUES (8, 'mentor5@gmail.com', 'Галя', 'Свентицька', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 7, 'Head of Strategy Department', '@mentor4', '/img/galya.png', 'mentor', 1000);
INSERT INTO usr(id, email, first_name, last_name, password, experience, position, telegram_contacts, path_to_photo, discriminator, balance) VALUES (9, 'mentor6@gmail.com', 'Галя', 'Свентицька', '$2a$10$be/cA.wM2hHTbyfehHCDuOY6Pr/FbIeQyToUfiTltiK0fVmK0U2bW', 7, 'Head of Strategy Department', '@mentor4', '/img/galya.png', 'mentor', 1000);

INSERT INTO role(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role(id, name) VALUES (2, 'ROLE_USER');
INSERT INTO role(id, name) VALUES (3, 'ROLE_MENTOR');

INSERT INTO users_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles(user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles(user_id, role_id) VALUES (3, 2);
INSERT INTO users_roles(user_id, role_id) VALUES (4, 2);
INSERT INTO users_roles(user_id, role_id) VALUES (5, 2);
INSERT INTO users_roles(user_id, role_id) VALUES (6, 2);
INSERT INTO users_roles(user_id, role_id) VALUES (3, 3);
INSERT INTO users_roles(user_id, role_id) VALUES (4, 3);
INSERT INTO users_roles(user_id, role_id) VALUES (5, 3);
INSERT INTO users_roles(user_id, role_id) VALUES (6, 3);

INSERT INTO course(id, price, title, description, bonuses) VALUES (1, 200, 'Йо оце назва курса', 'Мета нашого курсу, щоб ви почали монетизувати свій профіль вже під час навчання. А також сформували особистий план розвитку. Якщо у вас невеликий профіль або немає продукту, який би ви могли продавати, ми надаємо можливість продавати наші освітні продукти, і заробляти на цьому.', '30 днів з "Як заробляти на контенті всі уроки будуть доступні в особистому кабінеті в записі + для кожного потоку є окремий чат в телеграм для мотивації та спілкування');
INSERT INTO course(id, price, title, description, bonuses) VALUES (2, 200, 'Йо оце назва курса 2', 'Мета нашого курсу, щоб ви почали монетизувати свій профіль вже під час навчання. А також сформували особистий план розвитку. Якщо у вас невеликий профіль або немає продукту, який би ви могли продавати, ми надаємо можливість продавати наші освітні продукти, і заробляти на цьому.', '30 днів з "Як заробляти на контенті всі уроки будуть доступні в особистому кабінеті в записі + для кожного потоку є окремий чат в телеграм для мотивації та спілкування');
INSERT INTO course(id, price, title, description, bonuses) VALUES (3, 200, 'Йо оце назва курса 3', 'Мета нашого курсу, щоб ви почали монетизувати свій профіль вже під час навчання. А також сформували особистий план розвитку. Якщо у вас невеликий профіль або немає продукту, який би ви могли продавати, ми надаємо можливість продавати наші освітні продукти, і заробляти на цьому.', '30 днів з "Як заробляти на контенті всі уроки будуть доступні в особистому кабінеті в записі + для кожного потоку є окремий чат в телеграм для мотивації та спілкування');
INSERT INTO course(id, price, title, description, bonuses) VALUES (4, 200, 'Йо оце назва курса 4', 'Мета нашого курсу, щоб ви почали монетизувати свій профіль вже під час навчання. А також сформували особистий план розвитку. Якщо у вас невеликий профіль або немає продукту, який би ви могли продавати, ми надаємо можливість продавати наші освітні продукти, і заробляти на цьому.', '30 днів з "Як заробляти на контенті всі уроки будуть доступні в особистому кабінеті в записі + для кожного потоку є окремий чат в телеграм для мотивації та спілкування');
INSERT INTO course(id, price, title, description, bonuses) VALUES (5, 200, 'Йо оце назва курса 5', 'Мета нашого курсу, щоб ви почали монетизувати свій профіль вже під час навчання. А також сформували особистий план розвитку. Якщо у вас невеликий профіль або немає продукту, який би ви могли продавати, ми надаємо можливість продавати наші освітні продукти, і заробляти на цьому.', '30 днів з "Як заробляти на контенті всі уроки будуть доступні в особистому кабінеті в записі + для кожного потоку є окремий чат в телеграм для мотивації та спілкування');

INSERT INTO course_mentor(course_id, mentor_id) VALUES (1, 3);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (1, 4);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (1, 5);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (1, 6);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (1, 7);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (1, 8);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (1, 9);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (2, 5);
INSERT INTO course_mentor(course_id, mentor_id) VALUES (2, 6);

INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (1, 'Урок 1 – як організувати знімальний процес', 'Ля навчишся багато чого 1', 'Потужне наповнення контентом 1', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (2, 'Урок 2 – портретна та предметна зйомка на мобільний телефон', 'Ля навчишся багато чого 2', 'Потужне наповнення контентом 2', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (3, 'Урок 3 – самостійна відеозйомка для постів та сторіз', 'Ля навчишся багато чого 3', 'Потужне наповнення контентом 3', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (4, 'Урок 4 – як продавати за допомогою віжуалу', 'Ля навчишся багато чого 4', 'Потужне наповнення контентом 4', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (5, 'Урок 5 – що формує Tone of voice, як відрізнятись буквами?', 'Ля навчишся багато чого 5', 'Потужне наповнення контентом 5', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (6, 'Урок 6 – текст, який зберігають, як збільшити залученість аудиторії', 'Ля навчишся багато чого 6', 'Потужне наповнення контентом 6', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (7, 'Урок 7 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 7', 'Потужне наповнення контентом 7', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (8, 'Урок 7 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 8', 'Потужне наповнення контентом 8', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (9, 'Урок 7 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 9', 'Потужне наповнення контентом 9', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (10, 'Урок 8 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 10', 'Потужне наповнення контентом 10', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (11, 'Урок 9 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 11', 'Потужне наповнення контентом 11', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (12, 'Урок 10 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 12', 'Потужне наповнення контентом 12', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (13, 'Урок 11 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 13', 'Потужне наповнення контентом 13', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (14, 'Урок 12 – помилкові тексти, що людям не подобається читати', 'Ля навчишся багато чого 14', 'Потужне наповнення контентом 14', 25,  1);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (15, 'Урок 1 – про що писати в рекламі і як продати за допомогою тексту', 'Ля навчишся багато чого 8', 'Потужне наповнення контентом 8', 25,  2);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (16, 'Урок 2 – контент-стратегія: рубрикатор та розкладка', 'Ля навчишся багато чого 9', 'Потужне наповнення контентом 9', 25,  2);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (17, 'Урок 3 – шлях підписника: як блогер веде за собою аудиторію', 'Ля навчишся багато чого 10', 'Потужне наповнення контентом 10', 25,  2);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (18, 'Урок 4 – як із блога зробити бренд, і як із бренду зробити блог', 'Ля навчишся багато чого 11', 'Потужне наповнення контентом 11', 25,  2);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (19, 'Урок 5 – конструктор сторінки', 'Ля навчишся багато чого 12', 'Потужне наповнення контентом 12', 25,  2);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (20, 'Урок 6 – як розрахувати свою вартість', 'Ля навчишся багато чого 13', 'Потужне наповнення контентом 13', 25,  2);
INSERT INTO lesson(id, title, description, content, duration,  course_id) VALUES (21, 'Урок 7 – кому було б цікаво бути асистентом блогера і коли краще брати особистого асистента', 'Ля навчишся багато чого 14', 'Потужне наповнення контентом 14', 25,  2);

INSERT INTO packet(id, number_of_places, title, description, price, discount, course_id, path_to_image) VALUES (1, 0, 'BASIC БЕЗ ФІДБЕКУ', '<p class="card-text">
          Не впевнені, що інстаграм це ваше? Боїтеся фідбеку? Ви так "тільки спитати"?) Тоді цей курс
          дасть вам всі можливі знання та матеріали для того, щоб почати.
        <ol>
          <li> доступ до особистого кабінету, де зібрані всі уроки, чеклисти, документи, презентації,
            відео-туторіали</li>
          <li>чотири навчальні модулі: 16 уроків про інстаграм</li>
          <li>16 практичних домашніх завдань до кожного з уроків</li>
          <li> доступ до закритого чату в телеграм для спілкування лише серед студентів вашого потоку та
            лекторів</li>
          <li> партнерська програма для монетизації отриманих знань під час курсу</li>
        </ol>
        </p>', 2600, 10, 1, '/img/1basic.jpg');
INSERT INTO packet(id, number_of_places, title, description, price, discount, course_id, path_to_image) VALUES (2, 35, 'SERIOUS ONE', '<p class="card-text">Для тих, хто серйозно налаштований на розвиток в інстаграм. Ви тут, щоб
          навчитися подавати та продавати свій контент правильно. 16 домашніх завдань і 16 коментарів від
          наших лекторів.
        <ol>
          <li> все що входить в пакет BASIC</li>
          <li> 4 прямих ефіри після кожного модулю, з розбором домашніх і відповідями на ваші запитання
          </li>
          <li>доступ до закритого чату в телеграм для спілкування лише серед студентів вашого потоку та
            лекторів</li>
          <li> розбір основних помилок щодо домашніх в спільному чат</li>
        </ol>
        </p>', 4900, 15, 1, '/img/1ser.jpg');
INSERT INTO packet(id, number_of_places, title, description, price, discount, course_id, path_to_image) VALUES (3, 5, 'TOP BEST PREMIUM', ' <p class="card-text">
          А що після курсу? Отримай аналіз сторінки від Тані Пренткович після завершення навчання.
          Стратегічна сессія від наших стратегів допоможе розставити всі пріорітети до кінця року.
        <ol>
          <li> все що входить в пакет SERIOUS SHIT</li>
          <li> особистий фідбек від лекторів до кожного домашнього завдання</li>
          <li>додаткове спілкування з лекторами під час курсу, можливість отримати відповіді на запитання
            особистий аналіз сторінки від Тані Пренткович після завершення курсу, фідбек та поради, що
            робити далі</li>
          <li> Повний розбір профілю від команди PRentkovych agency., поради, ідеї щодо нових рубрик,
            активностей</li>
        </ol>
        </p>', 7200, 5, 1, '/img/1lux.jpg');

INSERT INTO packet(id, number_of_places, title, description, price, discount, course_id, path_to_image) VALUES (6, 5, 'TOP BEST PREMIUM', ' <p class="card-text">
          А що після курсу? Отримай аналіз сторінки від Тані Пренткович після завершення навчання.
          Стратегічна сессія від наших стратегів допоможе розставити всі пріорітети до кінця року.
        <ol>
          <li> все що входить в пакет SERIOUS SHIT</li>
          <li> особистий фідбек від лекторів до кожного домашнього завдання</li>
          <li>додаткове спілкування з лекторами під час курсу, можливість отримати відповіді на запитання
            особистий аналіз сторінки від Тані Пренткович після завершення курсу, фідбек та поради, що
            робити далі</li>
          <li> Повний розбір профілю від команди PRentkovych agency., поради, ідеї щодо нових рубрик,
            активностей</li>
        </ol>
        </p>', 7200, 5, 1, '/img/1lux.jpg');

INSERT INTO packet(id, number_of_places, title, description, price, discount, course_id, path_to_image) VALUES (5, 5, 'TOP BEST PREMIUM', ' <p class="card-text">
          А що після курсу? Отримай аналіз сторінки від Тані Пренткович після завершення навчання.
          Стратегічна сессія від наших стратегів допоможе розставити всі пріорітети до кінця року.
        <ol>
          <li> все що входить в пакет SERIOUS SHIT</li>
          <li> особистий фідбек від лекторів до кожного домашнього завдання</li>
          <li>додаткове спілкування з лекторами під час курсу, можливість отримати відповіді на запитання
            особистий аналіз сторінки від Тані Пренткович після завершення курсу, фідбек та поради, що
            робити далі</li>
          <li> Повний розбір профілю від команди PRentkovych agency., поради, ідеї щодо нових рубрик,
            активностей</li>
        </ol>
        </p>', 7200, 5, 1, '/img/1lux.jpg');

INSERT INTO packet(id, number_of_places, title, description, price, discount, course_id, path_to_image) VALUES (4, 5, 'TOP BEST PREMIUM', ' <p class="card-text">
          А що після курсу? Отримай аналіз сторінки від Тані Пренткович після завершення навчання.
          Стратегічна сессія від наших стратегів допоможе розставити всі пріорітети до кінця року.
        <ol>
          <li> все що входить в пакет SERIOUS SHIT</li>
          <li> особистий фідбек від лекторів до кожного домашнього завдання</li>
          <li>додаткове спілкування з лекторами під час курсу, можливість отримати відповіді на запитання
            особистий аналіз сторінки від Тані Пренткович після завершення курсу, фідбек та поради, що
            робити далі</li>
          <li> Повний розбір профілю від команди PRentkovych agency., поради, ідеї щодо нових рубрик,
            активностей</li>
        </ol>
        </p>', 7200, 5, 1, '/img/1lux.jpg');

INSERT INTO usr_course(course_id, user_id) VALUES (1, 1);
INSERT INTO usr_course(course_id, user_id) VALUES (2, 2);
INSERT INTO usr_course(course_id, user_id) VALUES (1, 3);
INSERT INTO usr_course(course_id, user_id) VALUES (2, 4);
INSERT INTO usr_course(course_id, user_id) VALUES (1, 5);
INSERT INTO usr_course(course_id, user_id) VALUES (2, 6);