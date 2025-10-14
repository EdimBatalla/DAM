<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Comarques ID</title>
            </head>
            <body>
                <h2>Probabilitat de precipitació</h2>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Nom Comarca</th>
                        <th>04/04 Matí</th>
                        <th>04/04 Tarda</th>
                        <th>05/04 Matí</th>
                        <th>05/04 Tarda</th>
                    </tr>

                    <xsl:for-each select="smc/comarca">
                        <xsl:variable name="idComarca" select="@id"/>
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@nomCOMARCA"/></td>
                            <xsl:for-each select="//prediccio[@idcomarca=$idComarca]/variable[position() &lt;= 2]">
                                
                                <td>
                                    <span>
                                        <xsl:attribute name="style">
                                            <xsl:if test="@probprecipitaciomati = 1">color:green</xsl:if>
                                            <xsl:if test="@probprecipitaciomati = 2">color:darkgreen</xsl:if>
                                            <xsl:if test="@probprecipitaciomati = 3">color:orange</xsl:if>
                                            <xsl:if test="@probprecipitaciomati = 4">color:red</xsl:if>
                                        </xsl:attribute>
                                        <xsl:value-of select="@probprecipitaciomati"/>
                                    </span>
                                </td>

                                <td>
                                    <span>
                                        <xsl:attribute name="style">
                                            <xsl:if test="@probprecipitaciotarda = 1">color:green</xsl:if>
                                            <xsl:if test="@probprecipitaciotarda = 2">color:darkgreen</xsl:if>
                                            <xsl:if test="@probprecipitaciotarda = 3">color:orange</xsl:if>
                                            <xsl:if test="@probprecipitaciotarda = 4">color:red</xsl:if>
                                        </xsl:attribute>
                                        <xsl:value-of select="@probprecipitaciotarda"/>
                                    </span>
                                </td>

                            </xsl:for-each>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>