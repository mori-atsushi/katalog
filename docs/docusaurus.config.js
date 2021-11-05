const lightCodeTheme = require('prism-react-renderer/themes/github');
const darkCodeTheme = require('prism-react-renderer/themes/dracula');

/** @type {import('@docusaurus/types').DocusaurusConfig} */
module.exports = {
  title: 'Katalog - A UI Catalog Library made with Jetpack Compose',
  tagline: 'A UI Catalog Library made with Jetpack Compose',
  url: 'https://crispy-waddle-c753833a.pages.github.io',
  baseUrl: '/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',
  organizationName: 'cyberagent-zemi',
  projectName: 'katalog',
  trailingSlash: false,
  themeConfig: {
    image: 'img/ogp.png',
    navbar: {
      title: 'Katalog',
      logo: {
        alt: 'Katalog Logo',
        src: 'img/logo.svg',
      },
      items: [
        {
          to: 'docs/getting-started',
          position: 'left',
          label: 'Getting Started',
        },
        {
          to: 'docs/main/register-and-start',
          activeBasePath: 'docs/main',
          position: 'left',
          label: 'Documentation',
        },
        {to: '/blog', label: 'Blog', position: 'left'},
        {
          href: 'https://github.com/facebook/docusaurus',
          label: 'GitHub',
          position: 'right',
        },
      ],
    },
    footer: {
      style: 'dark',
      links: [
        {
          title: 'Docs',
          items: [
            {
              label: 'Getting Started',
              to: '/docs/getting-started',
            },
            {
              label: 'Documentation',
              to: '/docs/main/register-and-start',
            },
            {
              label: 'Extensions',
              to: '/docs/main/extensions/compose-theme',
            },
          ],
        },
        {
          title: 'Blog',
          items: [
            {
              label: 'Welcome',
              to: '/blog/welcome',
            }
          ],
        },
        {
          title: 'More',
          items: [
            {
              label: 'Blog',
              to: '/blog',
            },
            {
              label: 'GitHub',
              href: 'https://github.com/cyberagent-zemi/katalog',
            },
          ],
        },
      ],
      copyright: `Copyright © ${new Date().getFullYear()} Katalog. Built with Docusaurus.`,
    },
    prism: {
      theme: lightCodeTheme,
      darkTheme: darkCodeTheme,
      additionalLanguages: ['kotlin'],
    },
  },
  presets: [
    [
      '@docusaurus/preset-classic',
      {
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          // Please change this to your repo.
          editUrl:
            'https://github.com/cyberagent-zemi/katalog/edit/main/docs/',
        },
        blog: {
          showReadingTime: true,
          // Please change this to your repo.
          editUrl:
            'https://github.com/cyberagent-zemi/katalog/edit/main/docs/blog/',
        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      },
    ],
  ],
};
