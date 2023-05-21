//Scripture Memorizer program || Derek Earl || BYU-Idaho 2023

#include <iostream>
#include <string>
#include <vector>

//C++ code to use a scripture memorizer.

std::vector<std::string> splitString(const std::string& input) {
    std::vector<std::string> words;
    std::string word;
    
    for (char c : input) {
        if (c == ' ') {
            if (!word.empty()) {
                words.push_back(word);
                word.clear();
            }
        } else {
            word += c;
        }
    }
    
    if (!word.empty()) {
        words.push_back(word);
    }
    
    return words;
}

int main() {
    std::string scripture;
    //Tells the user to enter a scripture to memorize.
    std::cout << "Enter a scripture to memorize: ";
    //Receives the scriture given by the user.
    std::getline(std::cin, scripture);
    
    std::vector<std::string> words = splitString(scripture);
    
    //Displays the scripture to memorize.
    std::cout << "Here is the scripture to memorize: " << scripture << std::endl;
    
    //Tells the user to press enter to remove one word a time.
    std::cout << "Press enter to remove one word at a time." << std::endl;
    std::cin.ignore(); // Ignore the newline character after the scripture input
    
    for (size_t i = 0; i < words.size(); ++i) {
        std::cout << "Press enter to remove the next word.";
        std::cin.ignore();
        //Replaces the words with _
        words[i] = "_";
        
        // Displays the scripture
        std::cout << "Scripture: ";
        for (const std::string& word : words) {
            std::cout << word << " ";
        }
        std::cout << std::endl;
    }
    

    //Displays this message when all the words have been removed.
    std::cout << "All words have been removed." << std::endl;
    
    return 0;
}