insert into users (id, password, username) values ('1', '$2y$11$gtaHbTQoYMId83ElB/wQRuk8gVkwjq6/43EGcpY.HVKVOsajwmqE6', 'potato')
insert into users (id, password, username) values ('2', '$2y$11$4ABZCpfOKzPCo9Mva7yZwuVMt.pedP7llx1P9KP7S/Wwjr9mOuABK', 'panda')
insert into users (id, password, username) values ('3', '$2y$11$zsPga7GLDTU/NVQa0FJehOVP2gdvd7hVSFpYTSucxyxX.eMBA1qQG', 'cupcake')
insert into users (id, password, username) values ('4', '$2y$11$3/9bklfeBE4LpnoECSvYfOmXqTmpnQ1dQjM4UExfVQ4fzb3r6wlFu', 'doggie')

insert into user_roles (user_id, role) values ('1', 'USER')
insert into user_roles (user_id, role) values ('1', 'ADMIN')
insert into user_roles (user_id, role) values ('2', 'USER')
insert into user_roles (user_id, role) values ('3', 'USER')
insert into user_roles (user_id, role) values ('4', 'USER')

insert into recipe (id, recipe_body, title, user_id) values ('1', '<h2>Ingredients</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>2 tablespoons granulated sugar</li>' || CHAR(10) || '<li>2 tablespoons instant coffee</li>' || CHAR(10) || '<li>2 tablespoons cold water</li>' || CHAR(10) || '<li>Ice, for serving</li>' || CHAR(10) || '<li>Milk, for serving</li>' || CHAR(10) || '</ul> &nbsp;' || CHAR(10) || '<h2>Instructions</h2>' || CHAR(10) || '<ol>' || CHAR(10) || '<li>In a medium bowl, combine sugar, coffee, and water. Using a hand mixer or a whisk, vigorously whisk until mixture turns silky smooth and shiny, then continue whisking until it thickens and holds stiff peaks.</li>' || CHAR(10) || '<li>Fill a glass most of the way full with ice and milk, then drop the whipped coffe mixture on top, mixing before drinking.</li>' || CHAR(10) || '</ol>', 'Dalgona Coffee', '2')
insert into recipe (id, recipe_body, title, user_id) values ('2', '<h2>Ingredients</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>280g all-purpose flour</li>' || CHAR(10) || '<li>1 and 1/2 tablespoons cornstarch</li>' || CHAR(10) || '<li>1 teaspoon baking soda</li>' || CHAR(10) || '<li>1/2 teaspoon salt</li>' || CHAR(10) || '<li>112g full-fat cream cheese, room temperature</li>' || CHAR(10) || '<li>100g granulated sugar</li>' || CHAR(10) || '<li>100g brown sugar</li>' || CHAR(10) || '<li>1 large egg, room temperature</li>' || CHAR(10) || '<li>2 teaspoons pure vanilla extract</li>' || CHAR(10) || '<li>180g white chocolate chips</li>' || CHAR(10) || '<li>1 and 1/4 cups roughly chopped Oreos</li>' || CHAR(10) || '</ul> &nbsp;' || CHAR(10) || '<h2>Instructions</h2>' || CHAR(10) || '<ol>' || CHAR(10) || '<li>Whisk the flour, cornstarch, baking soda, and salt together in a medium bowl. Set aside.</li>' || CHAR(10) || '<li>In a large bowl using a hand mixer or a stand mixer fitted with a paddle attachment, beat the cream cheese on medium-high speed until completely smooth and creamy. Add the butter and beat until combined (see photo for a visual), scraping down the sides and up the bottom of the bowl as needed. Add granulated sugar and brown sugar and beat on medium-high speed until smooth and creamy, about 2 minutes. Add the egg and vanilla and beat on high speed until combined, about 1 minute. Scrape down the sides and up the bottom of the bowl and beat again as needed to combine.</li>' || CHAR(10) || '<li>Add the dry ingredients to the wet ingredients and mix on low speed until combined. With the mixer running on low speed, beat in the white chocolate chips. Add the Oreos and beat on low speed or gently fold in with a rubber spatula or wooden spoon (dough is heavy) until combined. Cover and chill the dough for at least 2 hours in the refrigerator (and up to 4 days). If chilling for longer than a few hours, allow to sit at room temperature for at least 30 minutes before rolling and baking because the dough will be quite hard.</li>' || CHAR(10) || '<li>Preheat oven to 177°C. Line baking sheets with parchment paper or silicone baking mats. Set aside.</li>' || CHAR(10) || '<li>Roll cookie dough, a heaping 1.5 Tablespoons of dough per cookie, and place 3 inches apart on the baking sheets. Bake for 12-13 minutes or until lightly browned on the sides. The centers will look very soft.</li>' || CHAR(10) || '<li>Remove from the oven and allow cookies to cool on the baking sheet for 5 minutes before transferring to a wire rack to cool completely. While the cookies are still warm, I like to press a few more white chips or Oreo pieces into the tops– this is only for looks!</li>' || CHAR(10) || '<li>Cookies stay fresh covered at room temperature for up to 1 week.</li>' || CHAR(10) || '</ol>', 'Cookies and Cream Cookies', '3')
insert into recipe (id, recipe_body, title, user_id) values ('3', '<h2>Ingredients</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>115g salted or unsalted butter</li>' || CHAR(10) || '<li>228g semi-sweet chocolate bars, chopped</li>' || CHAR(10) || '<li>150g granulated sugar</li>' || CHAR(10) || '<li>50g brown sugar</li>' || CHAR(10) || '<li>3 large eggs</li>' || CHAR(10) || '<li>1 teaspoon pure vanilla extract</li>' || CHAR(10) || '<li>80g all-purpose flour</li>' || CHAR(10) || '<li>2 tablespoons cocoa powder</li>' || CHAR(10) || '<li>1/4 teaspoon salt</li>' || CHAR(10) || '<li>180g semi-sweet chocolate chips</li>' || CHAR(10) || '</ul> &nbsp;' || CHAR(10) || '<h2>Instructions</h2>' || CHAR(10) || '<ol>' || CHAR(10) || '<li>Melt the butter and chopped chocolate in a medium saucepan on medium heat, stirring constantly. Or melt in a large microwave safe bowl in 20 second increments, stirring after each. Remove from the heat, pour in a large mixing bowl, then allow to slightly cool for 10 minutes.</li>' || CHAR(10) || '<li>Adjust the oven rack to the lower third position and preheat oven to 177°C. Line the bottom and sides of a 9×9 inch square baking pan with aluminum foil or parchment, leaving an overhang on all sides. Set aside.</li>' || CHAR(10) || '<li>Whisk the granulated and brown sugars into the cooled chocolate/butter mixture. Add the eggs, one at a time, whisking until smooth after each addition. Whisk in the vanilla. Gently whisk in the flour, cocoa powder, and salt. Once combined, fold in the chocolate chips.</li>' || CHAR(10) || '<li>Pour/spoon batter into the prepared baking pan and bake for 35-36 minutes or until the brownies begin to pull away from the edges of the pan. A toothpick inserted in the center should come out with only a few moist crumbs when the brownies are done. All ovens are different, so keep an eye on them after 30 minutes and use the toothpick test to see when yours are finished.</li>' || CHAR(10) || '<li>Allow the brownies to cool completely in the pan set on a wire rack. Once cooled, lift the foil out of the pan using the overhang on the sides. Cut into squares. For neat squares, I use a very sharp knife and wipe it clean with a paper towel after each cut.</li>' || CHAR(10) || '<li>Brownies stay fresh in an airtight container at room temperature for 2 days or in the refrigerator for up to 1 week.</li>' || CHAR(10) || '</ol>', 'Chewy Chocolate Brownies', '3')
insert into recipe (id, recipe_body, title, user_id) values ('4', '<h2>Ingredients</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>345g all-purpose flour</li>' || CHAR(10) || '<li>50g granulated sugar</li>' || CHAR(10) || '<li>1 teaspoon salt</li>' || CHAR(10) || '<li>2 and 1/4 teaspoons dry yeast</li>' || CHAR(10) || '<li>180ml whole milk</li>' || CHAR(10) || '<li>60g unsalted butter</li>' || CHAR(10) || '<li>1 large egg, room temperature</li>' || CHAR(10) || '</ul>' || CHAR(10) || '<h2>Filling</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>60g unsalted butter, room temperature</li>' || CHAR(10) || '<li>50g brown or granulated sugar</li>' || CHAR(10) || '<li>1 tablespoon ground cinnamon</li>' || CHAR(10) || '</ul>' || CHAR(10) || '<h2>Vanilla icing</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>120g confectioners sugar</li>' || CHAR(10) || '<li>30ml milk or heavy cream</li>' || CHAR(10) || '<li>1 teaspoon pure vanilla extract</li>' || CHAR(10) || '</ul> &nbsp;' || CHAR(10) || '<h2>Instructions</h2>' || CHAR(10) || '<ol>' || CHAR(10) || '<li>Make the dough:&nbsp;Whisk the flour, sugar, salt, and yeast together. Set aside. Heat the milk and butter together in the microwave until the butter is melted and the mixture is warm to the touch, between&nbsp; 38-43°C. Pour the warm milk mixture into the dry ingredients. Add the egg. Using a handheld or stand mixer fitted with a dough hook or paddle attachment, or using a rubber spatula and mixing by hand, beat/mix the mixture until a soft dough forms. The dough is ready when it gently pulls away from the sides of the bowl. If the dough is pretty sticky, beat/mix in 2-4 extra Tablespoons of flour. (Keep in mind that you want the dough to remain on the softer side.)</li>' || CHAR(10) || '<li>Turn the dough out onto a lightly floured surface. With lightly floured hands, knead the dough for 3 minutes (for a visual, watch me knead in the video above). If you’d rather use the mixer to knead it, beat the dough on low speed for 3 minutes instead. After kneading, poke the dough with your finger – if it slowly bounces back, the dough is ready for the next step. If not, keep kneading.</li>' || CHAR(10) || '<li>Form the dough into a ball on your work surface. Cover it with a clean towel, aluminum foil, or plastic wrap, then let it rest for 30 minutes at room temperature. Alternatively, the ball of dough can rest in a covered and lightly greased mixing bowl.</li>' || CHAR(10) || '<li>Make the filling:&nbsp;After 30 minutes, use a rolling pin to roll the dough out into a 15×12 inch rectangle. Evenly spread the softened butter on top. Mix the sugar and cinnamon together and sprinkle it all over the buttered dough.</li>' || CHAR(10) || '<li>Grease a 9-inch round pie dish or cake pan with butter or nonstick spray.</li>' || CHAR(10) || '<li>Shape the cinnamon roll cake:&nbsp;See the video tutorial and my step-by-step photos above for a visual of this shaping step. Using a very sharp knife or a pizza cutter, cut the dough into six 2-inch wide strips. Roll up one strip and place it in the center of the pan. Coil the remaining 5 strips around the center roll, starting each strip at the end of the previous one to make one large cinnamon roll. Some of the filling may spill out as you pick up the strips, so just sprinkle it on top of the cake when you’re done shaping it.</li>' || CHAR(10) || '<li>Loosely cover the cake with aluminum foil or plastic wrap and allow it to rise in a relatively warm, draft-free environment for 1-2 hours or until double in size. (Tip:&nbsp;Rising at room temperature is usually fine, but on a particularly cold day, heat your oven to 66°C. Turn the oven off, place the shaped cake inside, and keep the door slightly ajar. This will be a warm environment for your dough to rise. After about 30 minutes, close the oven door to trap the air inside with the rising dough. When it’s doubled in size, remove from the oven.)</li>' || CHAR(10) || '<li>Bake:&nbsp;After the cake’s dough has doubled in size, preheat the oven to 177°C. Bake for 30-35 minutes or until golden brown. If you notice the top or edges browning too quickly, tent the cake with aluminum foil. While the giant cinnamon roll cake is baking, some spots may rise up more than other spots. That’s completely normal and expected from something this large. Simply remove the pan from the oven and, with the back of a spatula, press down the spots that are rising taller than others to help keep them even. Return to baking.</li>' || CHAR(10) || '<li>Remove the finished cinnamon roll cake from the oven and cool in the pan on a wire rack for 10 minutes. Meanwhile, make the icing.</li>' || CHAR(10) || '<li>Make the icing:&nbsp;Whisk the icing ingredients together. If you want a thicker icing, whisk in more confectioners’ sugar. If you want a thinner icing, whisk in more milk or cream. Drizzle all over warm cake and serve.</li>' || CHAR(10) || '<li>The cinnamon roll cake is best enjoyed the same day it’s made, but will remain fresh covered tightly for up to 4 days in the refrigerator.</li>' || CHAR(10) || '</ol>', 'Giant Cinnamon Roll Cake', '3')
insert into recipe (id, recipe_body, title, user_id) values ('5', '<h2>Ingredients</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>315g all-purpose flour</li>' || CHAR(10) || '<li>11g unsweetened natural cocoa powder</li>' || CHAR(10) || '<li>1 teaspoon baking soda</li>' || CHAR(10) || '<li>1/2 teaspoon salt</li>' || CHAR(10) || '<li>170g unsalted butter, room temperature</li>' || CHAR(10) || '<li>150g brown sugar</li>' || CHAR(10) || '<li>100g granulated sugar</li>' || CHAR(10) || '<li>1 large egg, room temperature</li>' || CHAR(10) || '<li>1 teaspoon pure vanilla extract</li>' || CHAR(10) || '<li>225g Nutella</li>' || CHAR(10) || '<li>130g chopped hazelnuts</li>' || CHAR(10) || '<li>28 soft caramel candies</li>' || CHAR(10) || '</ul> &nbsp;' || CHAR(10) || '<h2>Instructions</h2>' || CHAR(10) || '<ol>' || CHAR(10) || '<li>Whisk the flour, cocoa powder, baking soda, and salt together in a large bowl. Set aside.</li>' || CHAR(10) || '<li>Using a hand mixer or a stand mixer fitted with paddle attachment, cream the softened butter and both sugars together on medium speed until smooth, about 2 minutes. Add the egg and mix on high until combined, about 1 minute. Scrape down the sides and bottom of the bowl as needed. Add the vanilla and Nutella and beat on high until completely combined.</li>' || CHAR(10) || '<li>Pour the dry ingredients into the wet ingredients and beat on low speed until combined. Beat in the hazelnuts. Dough will be thick, yet airy and sticky. Cover and chill the dough for at least 3 hours in the refrigerator. If chilling for longer (up to 3 days), allow dough to sit at room temperature for at least 30 minutes before scooping and baking.</li>' || CHAR(10) || '<li>Preheat oven to 177°C. Line two large baking sheets with parchment paper or silicone baking mats. Set aside.</li>' || CHAR(10) || '<li>Cookie dough will be firm after chilling, but will come together with the warmth of your hands. Measure 1 scant Tablespoon of cookie dough and roll into a ball. Indent your thumb into it. Place caramel candy inside. (See recipe note.) Take another 1 scant Tablespoon of cookie dough and use it to completely cover the caramel candy on top. Roll the caramel-stuffed dough into an even ball. Make sure the caramel is completely wrapped inside. Sprinkle with coarse salt. Repeat with remaining cookie dough and caramels. Arrange cookie dough balls 3 inches apart on baking sheets. Place any remaining cookie dough balls in the refrigerator as you bake the other batches. (Best to keep those dough balls cold.)</li>' || CHAR(10) || '<li>Bake the cookies for 13-14 minutes until the edges appear set. Caramel may have oozed out a little. (That’s ok!) The centers will look very soft and under-baked. Remove from the oven and let cool on baking sheet for 5 minutes. The cookies will continue to “set” on the baking sheet during this time. Transfer cookies to a wire rack to cool completely. Use a thin spatula to help transfer the cookies to the cooling rack, especially if some caramel oozed out.</li>' || CHAR(10) || '<li>Cover and store leftover cookies at room temperature for up to 1 week.</li>' || CHAR(10) || '</ol>', 'Caramel Stuffed Nutella Cookies', '3')
insert into recipe (id, recipe_body, title, user_id) values ('6', '<h2>Ingredients</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>80ml fresh lime juice</li>' || CHAR(10) || '<li>zest of 2 limes</li>' || CHAR(10) || '<li>60ml agave nectar (or simply syrup)</li>' || CHAR(10) || '<li>1/4 cup fresh mint leaves</li>' || CHAR(10) || '<li>120ml light rum</li>' || CHAR(10) || '<li>5 cups crushed ice</li>' || CHAR(10) || '</ul> &nbsp;' || CHAR(10) || '<h2>Instructions</h2>' || CHAR(10) || '<ol>' || CHAR(10) || '<li>Add everything to a blender and blend on high until it reaches a slushie-like consistency. Taste. Add more sweetener, lime juice, rum, or mint based on your preference.</li>' || CHAR(10) || '</ol>', 'Frozen Mojito Slushies', '3')
insert into recipe (id, recipe_body, title, user_id) values ('7', '<h2>Ingredients</h2>' || CHAR(10) || '<ul>' || CHAR(10) || '<li>500g strawberries, sliced</li>' || CHAR(10) || '<li>seeds from 1 pomegranate</li>' || CHAR(10) || '<li>750ml red wine</li>' || CHAR(10) || '<li>2 cups pomegranate juice</li>' || CHAR(10) || '<li>soda, to taste</li>' || CHAR(10) || '</ul> &nbsp;' || CHAR(10) || '<h2>Instructions</h2>' || CHAR(10) || '<ol>' || CHAR(10) || '<li>Place the sliced strawberries and seeds in a large pitcher. Add wine and pomegranate juice. Allow to sit in the refrigerator for 6 – 24 hours. Taste; if you’d like it to be sweeter, add 1-2 Tablespoons granulated sugar, honey, or agave.</li>' || CHAR(10) || '<li>Pour the sangria with fruit into glasses and add a splash of soda to each glass. Garnish with a strawberry, if desired. Feel free to add ice to your glasses of sangria. Do not add ice directly to the pitcher – this waters the sangria down. Which, clearly, we don’t want! Cheers.</li>' || CHAR(10) || '</ol>', 'Strawberry Pomegranate Sangria', '3')
insert into recipe (id, recipe_body, title, user_id) values ('8', 'Database test', 'Test', '2')

insert into recipe_comment (id, recipe_comment, user_id, recipe_id) values ('1', 'My arm got tired whisking... like really tired', '3', '2')
insert into recipe_comment (id, recipe_comment, user_id, recipe_id) values ('2', 'I made this brownies the other day and they were amazing! Thank you for sharing the recipe', '2', '3')
insert into recipe_comment (id, recipe_comment, user_id, recipe_id) values ('3', 'Tried it and my whole family loved them', '3', '3')
insert into recipe_comment (id, recipe_comment, user_id, recipe_id) values ('4', 'Really good and soft brownies, messed a little on the cooking time so will try sometime soon again', '4', '3')
insert into recipe_comment (id, recipe_comment, user_id, recipe_id) values ('5', 'LOVE THEM!', '4', '3')
insert into recipe_comment (id, recipe_comment, user_id, recipe_id) values ('6', 'Test', '1', '8')