<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>Llista de ciutats</title>
      </head>
      <body>
        <h2>Ciutats i població</h2>
        <ol>
          <xsl:for-each select="ciudades/ciudad">
            <li>
              <xsl:value-of select="nombre"/> - 
              <xsl:value-of select="habitantes"/> habitants
            </li>
          </xsl:for-each>
        </ol>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
 