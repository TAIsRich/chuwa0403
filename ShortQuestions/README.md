# Markdown Learning

---

## 1. Headings

---

We use `#` to create different level of headings.

```text
# A first-level heading
## A second-level heading
### A third-level heading
```

# first-level

## second-level

### third-level 

## 2. Styling Text

----

| Style                  | Syntax             | Keyboard shortcut                         | Example                                  | Output                                   |
| :--------------------- | :----------------- | :---------------------------------------- | :--------------------------------------- | :--------------------------------------- |
| Bold                   | `** **` or `__ __` | Command+B (Mac) or Ctrl+B (Windows/Linux) | `**This is bold text**`                  | **This is bold text**                    |
| Italic                 | `* *` or `_ _`     | Command+I (Mac) or Ctrl+I (Windows/Linux) | `*This text is italicized*`              | *This text is italicized*                |
| Strikethrough          | `~~ ~~`            |                                           | `~~This was mistaken text~~`             | ~~This was mistaken text~~               |
| Bold and nested italic | `** **` and `_ _`  |                                           | `**This text is _extremely_ important**` | **This text is \*extremely\* important** |
| All bold and italic    | `*** ***`          |                                           | `***All this text is important***`       | ***All this text is important\***        |
| Subscript              | `<sub> </sub>`     |                                           | `<sub>This is a subscript text</sub>`    | This is a subscript text                 |
| Superscript            | `<sup> </sup>`     |                                           | `<sup>This is a superscript text</sup>`  | This is a superscript tex                |

## 3. Quoting Text

---

We can use a `>` to start a quote text part.

> This is a line of quote text.

## 4. Quoting Code

---

1. Short line quote code: Use `` to block your code.   

   `This is quoting code.`

2. Block quote code: use ``` to block your code.

   ```
   This is a block of code
   ```

## 5. Supported Color Models

---

| Color | Syntax         | Example                | Output                                                       |
| :---- | :------------- | :--------------------- | :----------------------------------------------------------- |
| HEX   | ``#RRGGBB``    | ``#0969DA``            | ![Screenshot of rendered GitHub Markdown showing how HEX value #0969DA appears with a blue circle.](https://docs.github.com/assets/cb-1560/images/help/writing/supported-color-models-hex-rendered.png) |
| RGB   | ``rgb(R,G,B)`` | ``rgb(9, 105, 218)``   | ![Screenshot of rendered GitHub Markdown showing how RGB value 9, 105, 218 appears with a blue circle.](https://docs.github.com/assets/cb-1962/images/help/writing/supported-color-models-rgb-rendered.png) |
| HSL   | ``hsl(H,S,L)`` | ``hsl(212, 92%, 45%)`` | ![Screenshot of rendered GitHub Markdown showing how HSL value 212, 92%, 45% appears with a blue circle.](https://docs.github.com/assets/cb-2068/images/help/writing/supported-color-models-hsl-rendered.png) |

The background color is `#ffffff` for light mode and `#000000` for dark mode.

## 6. Links

---

We can create a link text in brackets `[]` and then wrapping the URL in parentheses`()`. 

This GitHub website is [GitHub Pages](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax).

## 7. Images

---

We can upload a picture by using the following command.

```
![Picture Name](Picture URL)
```

Here are some examples for using relative links to display an image.

| Context                                                     | Relative Link                                                |
| :---------------------------------------------------------- | :----------------------------------------------------------- |
| In a `.md` file on the same branch                          | `/assets/images/electrocat.png`                              |
| In a `.md` file on another branch                           | `/../main/assets/images/electrocat.png`                      |
| In issues, pull requests and comments of the repository     | `../blob/main/assets/images/electrocat.png?raw=true`         |
| In a `.md` file in another repository                       | `/../../../../github/docs/blob/main/assets/images/electrocat.png` |
| In issues, pull requests and comments of another repository | `../../../github/docs/blob/main/assets/images/electrocat.png?raw=true` |

## 8. Lists

---

You can make an unordered list by preceding one or more lines of text with `-`, `*`, or `+`.

You can also make an ordered list by using `1.`, `2.`, `3.`, ...

## 9. Task Lists

---

To create a task list, preface list items with a hyphen and space followed by `[ ]`. To mark a task as complete, use `[x]`.

If a task list item description begins with a parenthesis, you'll need to escape it with \:

- [x] #739
- [ ] https://github.com/octo-org/octo-repo/issues/740
- [ ] Add delight to the experience when all tasks are complete :tada: