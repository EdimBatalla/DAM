<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	 <xsl:template match="/">
        <html>
            <head>
                <title>Comarques ID </title>
            </head>
            <body>
                <h1>Comarques ID</h1>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Nom Comarca</th>
                    </tr>
                      <xsl:for-each select="smc/comarca">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@nomCOMARCA"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>