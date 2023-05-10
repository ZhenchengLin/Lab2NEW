import com.google.cloud.translate.*;

import java.io.*;

public class TranslateFile {

    public static void main(String[] args) throws Exception {

        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // Set the source and target languages
        String sourceLang = "en";
        String targetLang = "zh-CN";

        // Read the input file
        String inputFilePath = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        StringBuilder inputText = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            inputText.append(line);
            inputText.append('\n');
        }
        reader.close();

        // Translate the input text
        Translation translation = translate.translate(inputText.toString(), Translate.TranslateOption.sourceLanguage(sourceLang),
                Translate.TranslateOption.targetLanguage(targetLang));

        // Write the translated text to a file
        String outputFilePath = args[0];
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        writer.write(translation.getTranslatedText());
        writer.close();

        System.out.println("Translation complete. Output file written to " + outputFilePath);
    }
}
