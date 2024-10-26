# Команды в Linux

### Создание файла Pets.txt
```sh
cat > Pets.txt << EOF
Собаки
Кошки
Хомяки
EOF
```

### Создание файла PackAnimals.txt
```sh
cat > PackAnimals.txt << EOF
Лошади
Верблюды
Ослы
EOF
```

### Объединение файлов в HumanFriends.txt
```sh
cat Pets.txt PackAnimals.txt > HumanFriends.txt
```

### Просмотр содержимого объединенного файла
```sh
cat HumanFriends.txt
```

### Проверка результата
```sh
ls
```

### Создание новой директории
```sh
mkdir FinalAtt
```

### Перемещение файла в новую директорию
```sh
mv HumanFriends.txt FinalAtt/
```

### Проверка результата
```sh
ls FinalAtt/
```
# MySQL в Linux

### Подключение репозитория MySQL и установка MySQL
```sh
sudo apt update
sudo apt install software-properties-common
sudo add-apt-repository 'deb http://repo.mysql.com/apt/ubuntu/ focal mysql-8.0'
sudo apt update
sudo apt install mysql-server
```

### Установка пакета из дополнительного репозитория
```sh
sudo apt install mysql-client
```

# Управление deb-пакетами

### Установка deb-пакета
```sh
sudo apt-get install curl
```

### Проверка установки deb-пакета
```sh
dpkg -l | grep curl
```

### Удаление deb-пакета
```sh
sudo dpkg -r curl
```

### Проверка удаления deb-пакета
```sh
dpkg -l | grep curl
```

# История команд в терминале Ubuntu

### Сохранение истории команд в файл
```sh
history > commands_history.txt