<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <!-- Plantilla principal -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Delicias Kitchen </title>
            </head>
            <body>
                <h1>Delicias Kitchen </h1>
                <table border="1">
                    <tr>
                        <th>Imatge</th>
                        <th>Títol</th>
                        <th>Temps</th>
                        <th>Ingredients</th>
                    </tr>
                      <xsl:for-each select="receptes/recepta">
                        <tr>
                            <td><img src="IMG/foto01.jpg" alt="titulo"/></td>
                            <td><img src="IMG/foto02.jpg" alt="titulo"/></td>
                            <td><img src="IMG/foto03.jpg" alt="titulo"/></td>
                            <td><xsl:value-of select="titol"/></td>
                            <td><xsl:value-of select="temps"/></td>
                            <td><xsl:value-of select="ingredients"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
