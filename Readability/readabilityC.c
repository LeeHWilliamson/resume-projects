#include <cs50.h> //works
#include <ctype.h>
#include <math.h>
#include <stdio.h>
#include <string.h>

float count_letters(string text);
float count_words(string text);
float count_sentences(string text);

int main(void)
{
    string text = get_string("Text: ");
    printf("%f letters\n", count_letters(text));
    printf("%f words\n", count_words(text));
    printf("%f sentences\n", count_sentences(text));
    printf("L = %f\n", count_letters(text) / count_words(text) * 100.0);
    printf("S = %f\n", count_sentences(text) / count_words(text) * 100.0);
    float L = count_letters(text) / count_words(text) * 100.0;
    float S = count_sentences(text) / count_words(text) * 100.0; // 4214
    int index = round(0.0588 * L - 0.296 * S - 15.8);
    printf("index = %f\n", round(0.0588 * L - 0.296 * S - 15.8));

    if (index < 1)
    {
        printf("Before Grade 1\n");
    }
    else if (index > 16)
    {
        printf("Grade 16+\n");
    }
    else
    {
        printf("Grade %i\n", index);
    }
}

float count_letters(string text)
{
    float sum = 0;
    for (int i = 0, n = strlen(text); i < n; i++)
    {
        if (islower(text[i]))
        {
            sum = (sum + 1);
        }
        else if (isupper(text[i]))
        {
            sum = (sum + 1);
        }
    }
    return sum;
}

float count_words(string text)
{
    float words = 0;
    for (int i = 0, n = strlen(text); i < n; i++)
    {
        if (text[i] == 32)
        {
            words = (words + 1);
        }
    }
    words++;
    return words;
}
float count_sentences(string text)
{
    float sentences = 0;
    for (int i = 0, n = strlen(text); i < n; i++)
    {
        if (text[i] == 33 | text[i] == 46 | text[i] == 63)
        {
            sentences++;
        }
    }
    return sentences;
}