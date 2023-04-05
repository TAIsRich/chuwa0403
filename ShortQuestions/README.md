# Usage of MarkDown

## Headings

Add "#" to determine the hierarchy level and typeface size of the heading.

```
# A first-level heading
## A second-level heading
### A third-level heading
```

# A first-level heading
## A second-level heading
### A third-level heading

## Styling text

| Style                     | Syntax          | Keyboard shortcut           | Example                                       | Output                                    |
| -------------------------|:---------------|:---------------------------|:----------------------------------------------|:------------------------------------------|
| Bold                      | ** ** or __ __ | Command+B (Mac) or Ctrl+B   | ```**This is bold text**  ```                       | **This is bold text**                          |
| Italic                    | * * or _ _      | Command+I (Mac) or Ctrl+I   | ```*This text is italicized*```                     | *This text is italicized*                   |
| Strikethrough             | ~~ ~~           |                             | ```~~This was mistaken text~~```                    | ~~This was mistaken text~~                     |
| Bold and nested italic    | ** ** and _ _   |                             | ```**This text is _extremely_ important**```        | **This text is _extremely_ important**          |
| All bold and italic       | *** ***         |                             | ```***All this text is important***```              | ***All this text is important***                 |
| Subscript                 | <sub> </sub>    |                             | ```<sub>This is a subscript text</sub>```           | <sub>This is a subscript text</sub>                   |
| Superscript               | <sup> </sup>    |                             | ```<sup>This is a superscript text</sup>```         | <sup>This is a superscript text</sup>                 |

## 3.Quoting text

``` 
Text that is not a quote
> Text that is a quote>
 ```
 Text that is not a quote
> Text that is a quote>

## 4.Quoting code

here's some code! :+1:

```
$(function(){
  $('div').html('I am a div.');
});
```
## 5.Supported color models

This is <span style="color: #FF4500">orange text</span> using HEX color model.
This is <span style="color: rgb(255, 165, 0)">orange text</span> using RGB color model.
This is <span style="color: hsl(39, 100%, 50%)">orange text</span> using HSL color model.

## 6.Links

This is my [Linkedin page](https://www.linkedin.com/in/minhe6122/)

## 7.Images

Add an inmage use `![description](image Relative Link)`

## 8.Lists

### example 1:
- George Washington
* John Adams
+ Thomas Jefferson
### example 2:
1. James Madison
2. James Monroe
3. John Quincy Adams
### Nested Lists

1. First list item
   - First nested list item
     - Second nested list item
### Task lists

- [ ] Task 1
- [x] Task 2 (completed)
- [ ] Task 3
## 9.Mentioning people and teams

@github/support What do you think about these updates?

## 10.Using emoji

Today is a beautiful day! ☀️🌷🌼🌸 I think I'll go for a walk in the park and enjoy the sunshine. 🚶‍♀️🌳🌞

## 11.Hiding content with comments

use ```<!--    -->``` to hiding content

```<!-- This content will not appear in the rendered Markdown -->```

## 12.Footnotes

Here is a simple footnote[^1].

A footnote can also have multiple lines[^2].

[^1]: My reference.
[^2]: To add line breaks within a footnote, prefix new lines with 2 spaces.
  This is a second line.


