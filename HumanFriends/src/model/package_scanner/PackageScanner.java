package model.package_scanner;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PackageScanner {
    private String packageName;

    public PackageScanner(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getSimpleClassNamesInLastPackages() {
        List<String> simpleClassNames = new ArrayList<>();
        String path = packageName.replace('.', '/');

        try {
            URL packageURL = Thread.currentThread().getContextClassLoader().getResource(path);

            if (packageURL != null) {
                File directory = new File(packageURL.getFile());
                if (directory.exists()) {
                    findSimpleClassNamesInLastPackages(directory, packageName, simpleClassNames);
                }
            }
        } catch (Exception e) {
            // Вывод стека для отладки и понятное пользователю сообщение
            System.err.println("Ошибка при сканировании пакета: " + e.getMessage());
            e.printStackTrace();
        }

        return simpleClassNames;
    }

     
    private void findSimpleClassNamesInLastPackages(File directory, String packageName, List<String> simpleClassNames) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
    
        for (File file : files) {
            if (file.isDirectory()) {
                findSimpleClassNamesInLastPackages(file, packageName + "." + file.getName(), simpleClassNames);
            } else if (file.getName().endsWith(".class")) {
                // Извлекаем имя класса и добавляем в список
                String simpleClassName = file.getName().substring(0, file.getName().length() - 6);
                simpleClassNames.add(simpleClassName);
            }
        }
    }
}