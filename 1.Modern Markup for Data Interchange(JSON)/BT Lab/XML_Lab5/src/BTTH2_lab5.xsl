<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTTH2_lab5.xsl
    Created on : August 21, 2020, 2:34 PM
    Author     : ADMIN
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
            <head>
                <title>BTTH2_lab5.xsl</title>
            </head>
            <body style="text-align:center; margin-top:30px;">
                <xsl:for-each select="breakfast_menu/food">
                    <div style="background-color:teal;color:white;padding:4px;width:50%;margin:auto;">
                        <span style="font-weight:bold">
                        <xsl:value-of select="name"/> - </span>
                        <xsl:value-of select="price"/>
                    </div>
                    <div style="margin-left:20px;margin-bottom:1em;font-size:10pt">
                        <p>
                            <xsl:value-of select="description"/>
                            <span style="font-style:italic"> (<xsl:value-of select="calories"/>
                            calories per serving)</span>
                        </p>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
