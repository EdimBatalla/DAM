<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Delicias Kitchen</title>
            </head>
            <body>
                <h1>Delicias Kitchen</h1>
                <table border="1">
                    <tr>
                        <th>Títol</th>
                        <th>Temps</th>
                        <th>Ingredients</th>
                    </tr>
                    <xsl:for-each select="receptes/recepta">
                        <tr>
                            <td><xsl:value-of select="titol"/></td>
                            <td><xsl:value-of select="temps"/></td>
                            <td>
                                <xsl:for-each select="ingredients/ingredient">
                                    <xsl:value-of select="."/>
                                    <xsl:if test="position() != last()">, </xsl:if>
                                </xsl:for-each>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
