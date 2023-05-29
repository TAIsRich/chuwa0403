# Headings
The number of # you use will determine the hierarchy level and typeface size of the heading.
```
# A first-level heading
## A second-level heading
### A third-level heading
```

# A first-level heading
## A second-level heading
### A third-level heading



# Styling text
You can indicate emphasis with bold, italic, strikethrough, subscript, or superscript text in comment fields and `.md` files.

Style|Syntax|Keyboard|shortcut Example|Output
-|-|-|-|-
Bold|`** **` or `__ __`|Command+B (Mac) or <br> Ctrl+B (Windows/Linux)|`**This is bold text**`|**This is bold text**
Italic|`* *` or `_ _`|Command+I (Mac) or <br> Ctrl+I (Windows/Linux)|`*This text is italicized*`|*This text is italicized*
Strikethrough|`~~ ~~`||`~~This was mistaken text~~`|~~This was mistaken text~~
Bold and nested italic|`** ** and _ _`||`**This text is _extremely_ important**`|**This text is _extremely_ important**
All bold and italic|`*** ***`||`***All this text is important***`|***All this text is important***
Subscript|`<sub> </sub>`||`<sub>This is a subscript text</sub>`|<sub>This is a subscript text</sub>
Superscript|`<sup> </sup>`||`<sup>This is a superscript text</sup>`|<sup>This is a superscript text</sup>

# Quoting text
You can quote text with a `>`.
```
Text that is not a quote

> Text that is a quote
```
Quoted text is indented, with a different type color.


> Text that is a quote

# Quoting code
You can quote text with a ` ``` text ``` ` 
```
text
```
or ``` `text` ```
`text`.

# Supported color models

In issues, pull requests, and discussions, you can call out colors within a sentence by using backticks. A supported color model within backticks will display a visualization of the color.

```
The background color is `#ffffff` for light mode and `#000000` for dark mode.
```

The background color is `#ffffff` for light mode and `#000000` for dark mode.

Color|Syntax|Example|Output
-|-|-|-
HEX|``` `#RRGGBB` ```|``` `#0969DA` ```|`#0969DA`
RGB|``` `rgb(R,G,B)` ```|``` `rgb(9, 105, 218)` ```|`rgb(9, 105, 218)`
HSL|``` `hsl(H,S,L)` ```|``` `hsl(212, 92%, 45%)` ```|`hsl(212, 92%, 45%)`	

# Links
You can create an inline link by wrapping link text in brackets `[ ]`, and then wrapping the URL in parentheses `( )`.

[google.com](www.google.com)

# Images

You can display an image by adding `!` and wrapping the alt text in `[ ]`. Alt text is a short text equivalent of the information in the image. Then, wrap the link for the image in parentheses `()`.

```
![http cat](https://httpcats.com/100.jpg)
```
![http cat](https://httpcats.com/100.jpg)

# Lists

You can make an unordered list by preceding one or more lines of text with `-`, `*`, or `+`.
```
- George Washington
* John Adams
+ Thomas Jefferson
```

- George Washington
* John Adams
+ Thomas Jefferson

To order your list, precede each line with a number.
```
1. James Madison
2. James Monroe
3. John Quincy Adams
```

1. James Madison
2. James Monroe
3. John Quincy Adams