<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>Temperatures per Comarca</title>
      </head>
      <body>
        <h2>Temperatures mínimes i màximes (04/04/2025)</h2>
        <table border="1">
          <tr>
            <th>Comarca</th>
            <th>Capital</th>
            <th>Temp. Mínima</th>
            <th>Temp. Màxima</th>
          </tr>

          <xsl:for-each select="smc/comarca">
            <xsl:variable name="idComarca" select="@id"/>
            <tr>
              <td><xsl:value-of select="@nomCOMARCA"/></td>
              <td><xsl:value-of select="@nomCAPITALCO"/></td>

              <xsl:for-each select="/smc/prediccio[@idcomarca=$idComarca]/variable[1]">
                <td>
                  <span style="color:blue">
                    <xsl:value-of select="@tempmin"/>
                  </span>
                </td>
                <td>
                  <span style="color:red">
                    <xsl:value-of select="@tempmax"/>
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