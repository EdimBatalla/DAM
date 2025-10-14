<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>Itinerari des de Barcelona</title>
      </head>
      <body>
        <h2>Itinerari: Barcelonès → Vallès Occidental → Osona → Barcelonès</h2>
        <table border="1">
          <tr>
            <th>Comarca</th>
            <th>05/04 Matí</th>
            <th>05/04 Tarda</th>
          </tr>

          <xsl:for-each select="smc/comarca[@id=13 or @id=40 or @id=24]">
            <xsl:variable name="idComarca" select="@id"/>
            <tr>
              <td><xsl:value-of select="@nomCOMARCA"/></td>

              <td>
                <xsl:for-each select="/smc/prediccio[@idcomarca=$idComarca]/variable[2]">
                  <span>
                    <xsl:attribute name="style">
                      <xsl:if test="@probprecipitaciomati = 1">color:green</xsl:if>
                      <xsl:if test="@probprecipitaciomati = 2">color:darkgreen</xsl:if>
                      <xsl:if test="@probprecipitaciomati = 3">color:orange</xsl:if>
                      <xsl:if test="@probprecipitaciomati = 4">color:red</xsl:if>
                    </xsl:attribute>
                    <xsl:value-of select="@probprecipitaciomati"/>
                  </span>
                </xsl:for-each>
              </td>

              <td>
                <xsl:for-each select="/smc/prediccio[@idcomarca=$idComarca]/variable[2]">
                  <span>
                    <xsl:attribute name="style">
                      <xsl:if test="@probprecipitaciotarda = 1">color:green</xsl:if>
                      <xsl:if test="@probprecipitaciotarda = 2">color:darkgreen</xsl:if>
                      <xsl:if test="@probprecipitaciotarda = 3">color:orange</xsl:if>
                      <xsl:if test="@probprecipitaciotarda = 4">color:red</xsl:if>
                    </xsl:attribute>
                    <xsl:value-of select="@probprecipitaciotarda"/>
                  </span>
                </xsl:for-each>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
